package com.bai3.bai5.service;

import com.bai3.bai5.entity.PHONGBAN;
import com.bai3.bai5.repository.PHONGBANRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PHONGBANService {
    @Autowired
    private PHONGBANRepository categoryRepository;

    public List<PHONGBAN> getAllCategories(){
        return categoryRepository.findAll();
    }
    public  PHONGBAN getPHONGBANById(String id){
        Optional<PHONGBAN> category= categoryRepository.findById(id);
        return category.orElse(null);
    }
    public void addBook(PHONGBAN category){
        categoryRepository.save(category);
    }
    public void updateBook(PHONGBAN category){
        categoryRepository.save(category);
    }
    public void deleteBook(String id){
        categoryRepository.deleteById(id);
    }
}
