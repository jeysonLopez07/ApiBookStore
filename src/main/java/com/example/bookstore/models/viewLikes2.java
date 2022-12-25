package com.example.bookstore.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class viewLikes2 {
    private Long bookId;
    private Integer Likes;
    private List<String> customer;
}
