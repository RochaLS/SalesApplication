package com.example.salesapplication.services;

import com.example.salesapplication.models.Sales;

import java.util.List;
import java.util.Optional;

public interface SalesServiceInterface {

    List<Sales> getAllSales();
    long addOne(Sales sale);

    Optional<Sales> getById(long id);

    long deleteOne(long id);

    long updateOne(long id, Sales sale);


}
