package com.softwareengineeringchallenge.restAPIchallge2.service;

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;
import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;

//imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
@Qualifier("ItemService")
public class ItemServiceMOCK implements ItemServiceImpl {

    // ERROR: Item not found
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found";

    private final ItemRepository itemRepository;
    private final ItemAdapter itemAdapter;

    @Autowired
    public ItemServiceMOCK(@Qualifier("ItemRepositoryMock") ItemRepository itemRepository, ItemAdapter itemAdapter) {
        this.itemRepository = itemRepository;
        this.itemAdapter = itemAdapter;
    }

    public ItemDto createItem(ItemDto itemDto) {
        Item item = itemAdapter.dtoToEntity(itemDto);
        item.setDescription(item.getDescription().toUpperCase());
        item.setName(item.getName().toUpperCase());

        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        return itemAdapter.entityToDto(item);
    }

    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    public String deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        itemRepository.delete(item);
        return "Item deleted successfully";
    }

}
