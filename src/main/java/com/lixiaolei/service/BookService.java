package com.lixiaolei.service;

import com.lixiaolei.entity.Book;

import java.util.Map;

public interface BookService {
    Map<String, Object> listBook(Map<String, Object> query);

    Map<String, Object> listBookType();

    Map<String, Object> addBook(Book book);

    Map<String, Object> haveBookcode(String bookcode);
}
