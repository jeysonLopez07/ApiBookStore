package com.example.bookstore.repositories;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long>{

   public BookModel findByBookId(Long bookId);

   public List<BookModel>  findByAvailable(Boolean available,Pageable pageable);

   public List<BookModel>  findAll();  
   
}
