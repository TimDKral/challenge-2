package com.softwareengineeringchallenge.restAPIchallge2.service;

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;
import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;


public interface ItemServiceImpl {
    
    ItemDto createItem(ItemDto itemDto);
    ItemDto getItem(Long id);
    ItemDto updateItem(Long id, ItemDto itemDto);
    String deleteItem(Long id);

}
