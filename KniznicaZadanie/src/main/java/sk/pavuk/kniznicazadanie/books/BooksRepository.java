package sk.pavuk.kniznicazadanie.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    // SELECT * FROM user WHERE email = ?
    @Query("SELECT s FROM Books s WHERE s.title = ?1")
    Optional<Books> findBookByTitle(String title);
}
