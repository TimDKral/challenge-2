package com.crud.SoftwareEngineeringChallenge.repository;

import com.crud.SoftwareEngineeringChallenge.entity.Item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
@Qualifier("ItemRepositoryMock")
public class ItemRepositoryMock implements ItemRepositoryInterface {
    // You can add custom methods or override existing methods specific to this repository if needed
    // Spring Data JPA already provides the basic CRUD methods
}