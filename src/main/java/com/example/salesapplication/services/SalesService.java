package com.example.salesapplication.services;

import com.example.salesapplication.models.Sales;
import com.example.salesapplication.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService implements SalesServiceInterface {

    @Autowired
    SalesRepository salesRepository;

    @Override
    public List<Sales> getAllSales() {
        return (List<Sales>) salesRepository.findAll();
    }

    @Override
    public long addOne(Sales sale) {
         salesRepository.save(sale);
         return 1;
    }

    @Override
    public Optional<Sales> getById(long id) {
        return salesRepository.findById(id);
    }

    @Override
    public long deleteOne(long id) {
        salesRepository.deleteById(id);
        return 1;
    }

    @Override
    public long updateOne(long id, Sales sale) {
        salesRepository.save(sale);
        return  1;
    }


}
