package com.softwareengineeringchallenge.restAPIchallge2.repository;

// local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;

// imported
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ItemRepositoryMock")
public interface ItemRepositoryMock extends ItemRepository {

}
