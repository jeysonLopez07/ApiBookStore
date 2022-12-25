package com.example.bookstore.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.LikeModel;
import com.example.bookstore.models.ViewLikeModel;
import com.example.bookstore.models.viewLikes2;
import com.example.bookstore.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping()
    public Object guardarDatos(@RequestBody ViewLikeModel miEntidad) {
        Object datos = likeService.guardarDatos(miEntidad);

        if (!Objects.isNull(datos)) {
            List<String> list = ((LikeModel) datos).getCustomer();
            list = list.stream().distinct().collect(Collectors.toList());

            viewLikes2 mostrarDatos = new viewLikes2(((LikeModel) datos).getBookId(), ((LikeModel) datos).getLikes(),list);
            return mostrarDatos;

        } else {
            String Mensaje = "No exite libro con ese Id";
            return Mensaje;
        }

    }
}
