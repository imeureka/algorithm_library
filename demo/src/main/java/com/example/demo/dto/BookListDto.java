package com.example.demo.dto;
import com.example.demo.models.Book;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class BookListDto {

    private String bookTitle;
    private String auther; // 저자
    private String publisher; // 출판사
    private int year; // 출판년도
    private String regitser_id; // 등록번호
    private String book_id; // 청구기호
    private String room; // 자료실

    public BookListDto(Book entity) {
        this.bookTitle = entity.getBookTitle();
        this.auther = entity.getAuther();
        this.publisher = entity.getPublisher();
        this.year = entity.getYear();
        this.regitser_id = entity.getRegitser_id();
        this.book_id = entity.getBook_id();
        this.room = entity.getRoom();
    }
}