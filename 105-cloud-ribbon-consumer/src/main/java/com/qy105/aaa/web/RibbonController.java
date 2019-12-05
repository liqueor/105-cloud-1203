package com.qy105.aaa.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qy105.aaa.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook(){
        LinkedList<BookInfo> forObject = restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
        return forObject;
    }
    public List<BookInfo> error(){
        System.out.println("服务熔断");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("zz");
        List<BookInfo> fallbackMethod = new LinkedList<>();
        fallbackMethod.add(bookInfo);
        return fallbackMethod;

    }
}
