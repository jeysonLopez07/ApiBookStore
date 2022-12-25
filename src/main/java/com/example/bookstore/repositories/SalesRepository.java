package com.example.bookstore.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.bookstore.models.SalesModel;

@Repository
public interface SalesRepository extends CrudRepository<SalesModel, Long>{


}
