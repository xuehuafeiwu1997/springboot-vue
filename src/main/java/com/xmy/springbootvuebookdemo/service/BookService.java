package com.xmy.springbootvuebookdemo.service;import com.xmy.springbootvuebookdemo.dao.BookDao;import com.xmy.springbootvuebookdemo.entity.Book;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;/** * @author xmy * @date 2021/4/25 6:07 下午 */@Servicepublic class BookService {    @Autowired    BookDao bookDao;    public List<Book> getAllBooks() {        return bookDao.getAllBooks();    }    public int saveBook(Book book) {        return bookDao.saveBook(book);    }    public Book findBookById(long id) {        return bookDao.findBookById(id);    }}