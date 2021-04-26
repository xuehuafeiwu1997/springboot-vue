package com.xmy.springbootvuebookdemo.controller;import com.github.pagehelper.PageHelper;import com.github.pagehelper.PageInfo;import com.xmy.springbootvuebookdemo.entity.Book;import com.xmy.springbootvuebookdemo.service.BookService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import java.util.List;/** * @author xmy * @date 2021/4/25 6:07 下午 */@RestControllerpublic class BookController {    @Autowired    BookService bookService;//    @GetMapping("/book/{pageNum}")//    public List<Book> getBook(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {//        PageHelper.startPage(pageNum,6);//        List<Book> bookList = bookService.getAllBooks();//        return bookList;//    }    @GetMapping("/book/{page}/{size}")    public PageInfo<Book> getBook(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {        PageHelper.startPage(page,size);        List<Book> bookList = bookService.getAllBooks();        PageInfo<Book> pageInfo = new PageInfo<>(bookList);        return pageInfo;    }    @PostMapping("/book/save")    public String saveBook(@RequestBody Book book) {        int result = bookService.saveBook(book);        if (result == 0) {            return "error";        } else {            return "success";        }    }    @GetMapping("/book/findBookById/{id}")    public Book findBookById(@PathVariable("id") long id) {        return bookService.findBookById(id);    }    @PutMapping("/book/update")    public String updateBook(@RequestBody Book book) {        int result = bookService.updateBook(book);        if (result == 0) {            return  "fail";        } else {            return "success";        }    }    @DeleteMapping("/book/deleteBookById/{id}")    public String deleteBookById(@PathVariable("id") long id) {        int result = bookService.deleteBookById(id);        if (result == 0) {            return "fail";        } else {            return "success";        }    }}