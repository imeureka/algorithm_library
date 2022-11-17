package com.example.demo.services;


import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private final BookRepository userRepository;

    @Transactional
    public List<Book> searchBook(String subTitle) {
//LCS 자바코드를 넣어주세요
// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
        List<Book> bookList = null;
        return bookList;
    }

    /*
    @Transactional
    public List searchLocation() {
//다익스트라 자바코드를 넣어주세요
// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
        List<Position> positionList = null;
        return positionList;
    }*/
}
