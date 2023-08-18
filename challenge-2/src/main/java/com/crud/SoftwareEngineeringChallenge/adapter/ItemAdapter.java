package com.crud.SoftwareEngineeringChallenge.adapter;

//local
import com.crud.SoftwareEngineeringChallenge.dto.ItemDto;
import com.crud.SoftwareEngineeringChallenge.entity.Item;

//imported
import org.springframework.stereotype.Component;

@Component
public class ItemAdapter {

    // Converts an Item object to an ItemDto object.
    public ItemDto entityToDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        return dto;
    }

    // Converts an ItemDto object to an Item object.
    public Item dtoToEntity(ItemDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        return item;
    }

}
