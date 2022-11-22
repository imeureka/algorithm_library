package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//import org.json.JSONObject;



@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;
    @Transactional
    public List<Book> searchBook(String subTitle) {
//LCS 자바코드를 넣어주세요
// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
        Search lcs = new Search();
        //ArrayList<String[]> book = lcs.searchBook(subTitle, lcs.readData());
        //ArrayList<String[]> book = new ArrayList<String[]>();
        List<Book> bookList = new ArrayList<Book>();

        for(String[] b : lcs.searchBook(subTitle, lcs.readData())){
            Book book = new Book(b[0], b[1], b[2], b[3], b[4], b[5]);
            bookList.add(book);
            System.out.println(book);
            //book.add(b);
        }
        //Book book2 = new Book(String,Stirng, SItnr, );
/*        for(int i = 0; i < 6; i++){
            System.out.println(book.get(i));
        }
//        ArrayList<String[]> bookTitleList = lcs.searchBook(subTitle, lcs.readData());
        bookList.add(book2);*/
//
//        for(String bookTitle : bookTitleList){
//            bookList.add(bookRepository.findBookByBookTitle(bookTitle));
//        }
//        return bookList;
        return bookList;
    }
//    @Transactional
//    public ArrayList<Book> searchBook(String subTitle) {
////LCS 자바코드를 넣어주세요
//        Search lcs = new Search();
//        ArrayList<String[]> book = new ArrayList<String[]>();
//        book = lcs.searchBook(subTitle, lcs.readData());
//        System.out.println(Arrays.toString(book.get(0)));
///*        ArrayList<Book> bookList = new ArrayList<Book>();
//        //bookList.add();
//        ArrayList<String[]>
//        //Book book = lcs.searchBook(subTitle, lcs.readData()).;
//        for(String[] book : lcs.searchBook(subTitle, lcs.readData())){
//
//        }
////          for (int bookindex : searchBook.get()) {
////            bookList.add(BookRepository.searchBook(subTitle);
////        }
//
//
//
//
//        bookList.add(subTitle);
//        ArrayList<Book> bookList = null;*/
//        return null;
//    }

//    public HashMap<String, Integer> searchBook(String subTitle) {
////LCS 자바코드를 넣어주세요
//// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
//        Search lcs = new Search();
//        HashMap<String, Integer> bookTitleList = lcs.searchBook(subTitle, lcs.readData());
//
////        HashMap<String, Object> bookTitleListJson = new HashMap<>();
////        bookTitleListJson.put("key1", "subtitle");
////        bookTitleListJson.put("key2", "lcs.readData()");
////
////        JSONObject json = new JSONObject(bookTitleListJson);
////        System.out.printf("JSON: %s", json);
//
//        List<Book> bookList = new ArrayList<Book>();
//
//        // bookTitleList.forEach((key, value) ->
//                // bookList.add(bookRepository.findBookByBookTitle(key.split(",")[0]))
////첫번째 쉼표까지 잘라서 주셔야된다.
//        //);
//
//        return bookTitleList;
//    }

    /*
    @Transactional
    public List searchLocation() {
//다익스트라 자바코드를 넣어주세요
// 만약 자바에서 클래스 여러개 나왔다면 클래스 있는걸로 폴더 만들어서 book 불러온것처럼 불러오기
        List<Position> positionList = null;
        return positionList;
    }*/
}
