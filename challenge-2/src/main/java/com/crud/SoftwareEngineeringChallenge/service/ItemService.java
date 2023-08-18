package com.crud.SoftwareEngineeringChallenge.service;

import com.crud.SoftwareEngineeringChallenge.entity.Item;
import com.crud.SoftwareEngineeringChallenge.repository.ItemRepository;
import com.crud.SoftwareEngineeringChallenge.repository.ItemRepositoryInterface;
import com.crud.SoftwareEngineeringChallenge.adapter.ItemAdapter;
import com.crud.SoftwareEngineeringChallenge.dto.ItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ItemService")
public class ItemService implements ItemServiceInterface {

    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found";

    ItemRepositoryInterface itemRepository;
    //private final ItemRepository itemRepository;

    private final ItemAdapter itemAdapter;

    @Autowired
    public ItemService(@Qualifier("ItemRepositoryMock") ItemRepositoryInterface itemRepository, ItemAdapter itemAdapter) {
        this.itemRepository = itemRepository;
        this.itemAdapter = itemAdapter;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = itemAdapter.dtoToEntity(itemDto);
        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    @Override
    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        return itemAdapter.entityToDto(item);
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    @Override
    public String deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        itemRepository.delete(item);
        return "Item deleted successfully";
    }
}