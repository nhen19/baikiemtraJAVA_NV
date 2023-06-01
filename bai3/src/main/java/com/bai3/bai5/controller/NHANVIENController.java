package com.bai3.bai5.controller;

import com.bai3.bai5.entity.NHANVIEN;
import com.bai3.bai5.service.NHANVIENService;
import com.bai3.bai5.service.PHONGBANService;
import com.bai3.bai5.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RequestMapping("")
@Controller
public class NHANVIENController {
    @Autowired
    private NHANVIENService bookService;
    @Autowired
    private PHONGBANService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title","Trang chủ");
        return "book/index";
    }
//    @GetMapping("/list")
//    public String GetListBooks(Model model){
//        List<NHANVIEN> list= bookService.getAllNHANVIENs();
//        list.sort((o1, o2) ->  o1.getTen_NV().compareToIgnoreCase(o2.getTen_NV()));
//        model.addAttribute("list",list);
//        model.addAttribute("title","Book List");
//        return "book/list";
//    }
    @GetMapping("/list")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<NHANVIEN> bookPage = bookService.findAllPage(pageable);
        model.addAttribute("bookPage", bookPage);
        return "book/list";
    }

//    @GetMapping("/search")
//    public String getSearchBooks(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "") String search) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<NHANVIEN> bookPage;
//
//        if (!search.isEmpty()) {
//            bookPage = bookService.searchByName(search, pageable);
//        } else {
//            bookPage = bookService.findAllPage(pageable);
//        }
//        model.addAttribute("bookPage", bookPage);
//        model.addAttribute("search", search);
//
//        return "book/list";
//    }


    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book",new NHANVIEN());
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("users",userService.getAllUsers());
        model.addAttribute("title","Add Book");
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") @Valid NHANVIEN book, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){

            bookService.addNHANVIEN(book);
            return "redirect:/list";
        }
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("title","Add Book");
        model.addAttribute("users",userService.getAllUsers());

        return "book/add";
    }
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") String id,Model model){
        NHANVIEN editBook=bookService.getNHANVIENById(id);
        if(editBook!=null){
            model.addAttribute("book",editBook);
            model.addAttribute("title","Edit Book");
            model.addAttribute("categories",categoryService.getAllCategories());
            model.addAttribute("users",userService.getAllUsers());

            return "book/edit";
        }
        return "not-found";

    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") @Valid NHANVIEN book, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
            bookService.updateNHANVIEN(book);
            return "redirect:/books/list";
        }
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("users",userService.getAllUsers());
        model.addAttribute("title","Edit Book");
        return "book/edit";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        NHANVIEN book=bookService.getNHANVIENById(id);
        if(book!=null){
            bookService.deleteNHANVIEN(id);
            return "redirect:/list";
        }
        return "not-found";
    }

}
