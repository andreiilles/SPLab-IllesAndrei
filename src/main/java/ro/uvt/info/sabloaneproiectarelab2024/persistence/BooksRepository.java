package ro.uvt.info.sabloaneproiectarelab2024.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.sabloaneproiectarelab2024.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

}