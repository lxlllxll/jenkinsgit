package com.lixiaolei.dao;

import com.lixiaolei.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    List<Book> listBook(Map<String, Object> query);

    List<Map<String, Object>> listBookType();

    void addBook(Book book);

    List<Map<String, Object>> haveBookcode(String bookcode);
}
