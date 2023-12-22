package sk.pavuk.kniznicazadanie.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> getBooks(){
        return booksService.getBooks();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Books books){
        booksService.addNewBook(books);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("BookId") Integer bookId){
        booksService.deleteBook(bookId);

    }

}


