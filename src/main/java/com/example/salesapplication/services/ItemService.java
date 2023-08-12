package com.example.salesapplication.services;

import com.example.salesapplication.models.Items;
import com.example.salesapplication.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceInterface {

    @Autowired
    ItemRepository itemRepository;
    @Override
    public List<Items> getAllItems() {
        return (List<Items>) itemRepository.findAll();
    }
}
