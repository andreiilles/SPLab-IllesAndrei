package ro.uvt.info.sabloaneproiectarelab2024.persistence;

import org.springframework.stereotype.Repository;
import ro.uvt.info.sabloaneproiectarelab2024.Author;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
