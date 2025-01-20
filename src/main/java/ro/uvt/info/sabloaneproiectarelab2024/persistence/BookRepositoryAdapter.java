package ro.uvt.info.sabloaneproiectarelab2024.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository booksRepository;

    @Autowired
    public BookRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }
}