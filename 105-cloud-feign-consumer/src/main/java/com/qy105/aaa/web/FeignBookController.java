package com.qy105.aaa.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qy105.aaa.model.BookInfo;
import com.qy105.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class FeignBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook() {
        List<BookInfo> allBook = bookService.getAllBook();
        System.out.println("feign get book " + allBook.size());
        return allBook;
    }
}

