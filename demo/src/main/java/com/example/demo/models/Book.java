package com.example.demo.models;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {

    @Column(name = "book_title", length = 50)
    private String bookTitle; // 서명
    @Column(name = "auther", length = 50)
    private String auther; // 저자
    @Column(name = "publisher", length = 50)
    private String publisher; // 출판사
    @Column(name = "year")
    private int year; // 출판년도
    @Column(name = "regitser_id", length = 50)
    private String regitser_id; // 등록번호
    @Id // PK 고유한 값
    @Column(name = "book_id", length = 50)
    private String book_id; // 청구기호
    @Column(name = "room", length = 50)
    private String room; // 자료실

    @Builder
    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
        this.auther = auther;
        this.publisher = publisher;
        this.year = year;
        this.regitser_id = regitser_id;
        this.book_id = book_id;
        this.room = room;
    }
}