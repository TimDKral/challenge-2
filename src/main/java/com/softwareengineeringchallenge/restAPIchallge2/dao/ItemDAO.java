package com.softwareengineeringchallenge.restAPIchallge2.dao;
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;

public interface ItemDAO {
    Item save(Item item);
    Item findById(Long id);
    void delete(Item item);    
}
