package it.johnson.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import it.johnson.onlinebookstore.entities.BookCategory;

@RepositoryRestResource(collectionResourceRel= "bookCategory", path="book-category")
public interface BookcategoryRepository extends JpaRepository<BookCategory, Long> {

}
