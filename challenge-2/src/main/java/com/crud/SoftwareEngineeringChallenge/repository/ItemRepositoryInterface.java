package com.crud.SoftwareEngineeringChallenge.repository;

import com.crud.SoftwareEngineeringChallenge.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryInterface extends JpaRepository<Item, Long> {
}