package com.qy105.aaa.web;

import com.qy105.aaa.model.BookInfo;
import com.qy105.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
//    private int i =1;
    @GetMapping("/getAllBook")
    @ResponseBody
    public List<BookInfo> getAllBook() throws InterruptedException {
        System.out.println("get request in");
        List<BookInfo> allBook = bookService.getAllBook();
        if (null == allBook) {
            return null;
        }
        for (BookInfo bookInfo : allBook) {
            System.out.println(bookInfo);
        }
//        if (++i%2 ==0){
//            throw new IllegalArgumentException();
//        }
        return allBook;
    }
}