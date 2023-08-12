package com.example.salesapplication.repositories;

import com.example.salesapplication.models.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long> {

}
