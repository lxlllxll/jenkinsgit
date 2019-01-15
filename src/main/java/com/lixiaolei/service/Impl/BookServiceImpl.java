package com.lixiaolei.service.Impl;

import com.lixiaolei.dao.BookMapper;
import com.lixiaolei.entity.Book;
import com.lixiaolei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper dao;

    @Override
    public Map<String, Object> listBook(Map<String, Object> query) {
        Map map = new HashMap();
        List<Book> listBook = dao.listBook(query);
        map.put("listBook", listBook);
        return map;
    }

    @Override
    public Map<String, Object> listBookType() {
        Map map = new HashMap();
        List<Map<String,Object>> listBookType = dao.listBookType();
        map.put("listBookTypeInfo",listBookType);
        return map;
    }

    @Override
    public Map<String, Object> addBook(Book book) {
        Map map = new HashMap();
        int flag = 0;
        try {
            if(book.getBegintime()==null||book.getBegintime().toString()=="") {
                book.setBegintime(new Date());
            }
                dao.addBook(book);
            flag=1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            map.put("addBookInfo","添加成功");
        }else{
            map.put("addBookInfo","添加失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> haveBookcode(String bookcode) {
        Map map = new HashMap();
        List<Map<String,Object>> list = dao.haveBookcode(bookcode);
        if(list.size()>0){
            map.put("haveBookcodeInfo","图书编号存在");
        }else{
            map.put("haveBookcodeInfo","图书编号不存在");
        }
        return map;
    }
}
