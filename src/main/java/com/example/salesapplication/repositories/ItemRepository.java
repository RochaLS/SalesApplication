package com.example.salesapplication.repositories;

import com.example.salesapplication.models.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Items, String> {

}
