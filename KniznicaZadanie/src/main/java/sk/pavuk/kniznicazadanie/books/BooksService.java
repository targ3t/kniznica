package sk.pavuk.kniznicazadanie.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getBooks(){
        return booksRepository.findAll();
    }

    public void addNewBook(Books books) {
        Optional<Books> userOptional = booksRepository.findBookByTitle(books.getTitle());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Titul je už pridaný");
        }
        booksRepository.save(books);
    }

    public void deleteBook(Integer bookId) {
        boolean exists = booksRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("book with id " + bookId + " does not exist");
        }
        booksRepository.deleteById(bookId);
    }


}



