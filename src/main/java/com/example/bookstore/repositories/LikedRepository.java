package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.bookstore.models.LikeModel;

import jakarta.transaction.Transactional;

@Repository
public interface LikedRepository extends CrudRepository<LikeModel, Long>{
   public LikeModel findByBookId(Long bookId);
}
