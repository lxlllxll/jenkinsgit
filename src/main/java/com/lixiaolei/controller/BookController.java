package com.lixiaolei.controller;

import com.lixiaolei.entity.Book;
import com.lixiaolei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping("/showBook")
    public String showBook(){
        return "book";
    }

    @RequestMapping("/listBook")
    @ResponseBody
    public Map<String,Object> listBook(@RequestBody Map<String,Object> query){
        return service.listBook(query);
    }

    @RequestMapping("/listBookType")
    @ResponseBody
    public Map<String,Object> listBookType(){
        return service.listBookType();
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public Map<String,Object> addBook(@RequestBody Book book){
        return service.addBook(book);
    }

    @RequestMapping("/haveBookcode")
    @ResponseBody
    public Map<String,Object> haveBookcode(String bookcode){
        return service.haveBookcode(bookcode);
    }

}
