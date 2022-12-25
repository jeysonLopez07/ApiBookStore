package com.example.bookstore.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.models.BookModel;
import com.example.bookstore.models.ConsultaPaginacion;
import com.example.bookstore.services.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping()
    public ConsultaPaginacion getBooksPaginated(@RequestParam(name = "param1", defaultValue = "1") int page,
            @RequestParam(name = "param2", defaultValue = "12") int size,
            @RequestParam(name = "param3", defaultValue = "asc") String sort) {
        Boolean available = true;
        List<BookModel> l = bookService.getBooksPaginated(page - 1, size, sort, available);
        List<BookModel> l2 = bookService.bookTotal();

        double result = Double.parseDouble(String.valueOf(l2.size())) / Double.parseDouble(String.valueOf(size));

        System.out.print(l2.size());
        System.out.print(size);
        System.out.print(result);
        int result2 = (int) Math.ceil(result);

        ConsultaPaginacion arrayObjetos = new ConsultaPaginacion(l, size, l.size(), l2.size(), result2, page);
        return arrayObjetos;

    }

    @PostMapping()
    public BookModel postMethodName(@RequestBody BookModel book) {
        if (book.getAvailable() == null || book.getAvailable().toString() == "") {
            book.setAvailable(true);
        }

        return this.bookService.saveBook(book);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.bookService.deleteBook(id);
        if (ok) {
            return "200 Ok";
        } else {
            return "No se Eliminó";
        }
    }

    @PutMapping(path = "/{id}")
    public Object  Actualizar(@PathVariable("id") Long id, @RequestBody BookModel book) {
        BookModel l = this.bookService.getBookById(id);

        if ((book.getTitle() == null || book.getTitle() == "") ||
                (book.getStock() == null || book.getStock().toString() == "") ||
                (book.getSalePrice() == null || book.getSalePrice().toString() == "")) {

            String MessageValidation = "Campo titulo,Stock y SalePrice son obligatorios";
            return MessageValidation;
        }

        if (book.getAvailable() == null || book.getAvailable().toString() == "") {
            book.setAvailable(true);
        }

        if (Objects.isNull(l)) {
            String MessageError = "No se encontró registro con ese bookId";
            return  MessageError ;
        } else {
            
            l.setBookId(id);
            l.setTitle(book.getTitle());
            l.setDescription(book.getDescription());
            l.setStock(book.getStock());
            l.setSalePrice(book.getSalePrice());
            l.setAvailable(book.getAvailable());
            bookService.saveBook(l);
            BookModel query = this.bookService.getBookById(id);
            return  query;
        }

    }

    @PersistenceContext
    private EntityManager entityManager;

    @PatchMapping(path = "/{id}")
    public Object ActualizarPath(@PathVariable("id") Long id, @RequestBody BookModel book) {
        BookModel l = this.bookService.getBookById(id);
        if (!Objects.isNull(l)) {

            if (book.getTitle() != null) {
                l.setTitle(book.getTitle());
            }

            if (book.getDescription() != null) {
                l.setDescription(book.getDescription());
            }

            if (book.getTitle() != null) {
                l.setTitle(book.getTitle());
            }
            if (book.getStock() != null) {
                l.setStock(book.getStock());
            }
            if (book.getSalePrice() != null) {
                l.setSalePrice(book.getSalePrice());
            }

            if (book.getAvailable() != null) {
                l.setAvailable(book.getAvailable());
            }

            return  bookService.saveBook(l);

        } else {
            String MessageError = "No se encontró registro con ese bookId";
            return  MessageError;
        }

    }

}
