package com.crud.SoftwareEngineeringChallenge.service;

import com.crud.SoftwareEngineeringChallenge.dto.ItemDto;

public interface ItemServiceInterface {

    ItemDto createItem(ItemDto itemDto);
    
    ItemDto getItem(Long id);

    ItemDto updateItem(Long id, ItemDto itemDto);

    String deleteItem(Long id);
}