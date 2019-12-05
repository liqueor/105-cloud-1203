package com.qy105.aaa.service;

import com.qy105.aaa.model.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Administrator
 */
@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {
    /**
     * 得到所有书籍
     *
     * @return 指定链接的 url 和参数  ，其中RequestParam 注解，必须配置，否则找不到参数
     */
    @GetMapping(value = "/getAllBook")
    List<BookInfo> getAllBook();
}
