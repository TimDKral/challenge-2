package com.crud.SoftwareEngineeringChallenge.repository;

//local
import com.crud.SoftwareEngineeringChallenge.entity.Item;

//imported
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
