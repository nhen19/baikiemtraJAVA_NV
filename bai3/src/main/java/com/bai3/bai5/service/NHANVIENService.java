package com.bai3.bai5.service;

import com.bai3.bai5.entity.NHANVIEN;
import com.bai3.bai5.repository.NHANVIENRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NHANVIENService {
    @Autowired
    private NHANVIENRepository NHANVIENRepository;

    public List<NHANVIEN> getAllNHANVIENs(){
        return NHANVIENRepository.findAll();
    }
    public List<NHANVIEN> getSearchNHANVIENs(String input){
        return NHANVIENRepository.searchName(input);
    }
    public NHANVIEN getNHANVIENById(String id){
        Optional<NHANVIEN> NHANVIEN= NHANVIENRepository.findById(id);
        return NHANVIEN.orElse(null);
    }
    public void addNHANVIEN(NHANVIEN NHANVIEN){
        NHANVIENRepository.save(NHANVIEN);
    }
    public Page<NHANVIEN> findAllPage (Pageable pageable){
        return NHANVIENRepository.findAll(pageable);
    }


    public void updateNHANVIEN(NHANVIEN NHANVIEN){
        NHANVIENRepository.save(NHANVIEN);
    }
    public void deleteNHANVIEN(String id){
        NHANVIENRepository.deleteById(id);
    }
}
