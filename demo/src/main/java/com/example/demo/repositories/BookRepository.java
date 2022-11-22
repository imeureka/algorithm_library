package com.example.demo.repositories;
import com.example.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Book findBookByBookTitle(String bookTitle);
    //Survey survey = surveyRepository.findSurveyBySurveyId(surveyId);
}
