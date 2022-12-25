package com.example.bookstore.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.bookstore.models.BookModel;
import com.example.bookstore.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    
    public List<BookModel> getBooksPaginated(int page, int size,String sort,Boolean available) {
    
        Pageable pageable;

        if (sort.equals("asc")) {
             pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        } else if (sort.equals("desc")) {
            pageable  = PageRequest.of(page, size, Sort.by("title").descending());
        }else {
            pageable = PageRequest.of(page, size);
        }
        return bookRepository.findByAvailable(available,pageable);
    }
    
    public BookModel saveBook(BookModel book){
        return bookRepository.save(book);
    }

    public List<BookModel> bookTotal(){
        return bookRepository.findAll();
    }




    public boolean deleteBook(Long id){
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public BookModel getBookById(Long id){
        return bookRepository.findByBookId(id);
    }

}
