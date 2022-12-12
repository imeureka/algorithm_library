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
        Search lcs = new Search();
        List<Book> bookList = new ArrayList<Book>();

        for(String[] b : lcs.searchBook(subTitle, lcs.readData())){
            Book book = new Book(b[0], b[1], b[2], b[3], b[4], b[5]);
            bookList.add(book);
            System.out.println(book);
        }

        return bookList;
    }



    @Transactional
    public List<String> searchLocation(String b, String room) {

        ArrayList<String> bookPath = new ArrayList<String>();
        int start = 210;
        int dest = Dijkstra.getLocation(b, room);
        Dijkstra.setting();
        Dijkstra.d[start] = 0;
        Dijkstra.visited[start] = 1;
        Dijkstra.dijkstra(start);
        int index = 1;
        Dijkstra.path[index++] = dest;
        index = Dijkstra.findPath(start, dest, index);
        bookPath = Dijkstra.convertCoordinate(Dijkstra.path);
//        List positionList = null;

        for(String str : bookPath){
            System.out.println(str);
        }

        return bookPath;
    }
}
