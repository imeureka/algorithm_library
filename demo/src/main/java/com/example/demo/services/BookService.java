package com.example.demo.services;


import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Transactional
    public HashMap<String, Integer> searchBook(String subTitle) {
//LCS 자바코드를 넣어주세요
// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
        Search lcs = new Search();
        HashMap<String, Integer> bookTitleList = lcs.searchBook(subTitle, lcs.readData());

        List<Book> bookList = new ArrayList<Book>();

        // bookTitleList.forEach((key, value) ->
                // bookList.add(bookRepository.findBookByBookTitle(key.split(",")[0]))
//첫번째 쉼표까지 잘라서 주셔야된다.
        //);

        return bookTitleList;
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
