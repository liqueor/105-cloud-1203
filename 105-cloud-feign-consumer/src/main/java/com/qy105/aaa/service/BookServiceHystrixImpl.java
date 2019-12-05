package com.qy105.aaa.service;

import com.qy105.aaa.model.BookInfo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class BookServiceHystrixImpl implements BookService {
    @Override
    public List<BookInfo> getAllBook() {
        System.out.println("服务降级中");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("123");
        List<BookInfo> fallbackMethod = new LinkedList<>();
        fallbackMethod.add(bookInfo);
        return fallbackMethod;
    }
}
