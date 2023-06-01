package com.bai3.bai5.repository;

import com.bai3.bai5.entity.NHANVIEN;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NHANVIENRepository extends JpaRepository<NHANVIEN, String> {
    @Query("SELECT b FROM NHANVIEN b WHERE b.Ten_NV LIKE %?1%")
    List<NHANVIEN> searchName(String input);
    Page<NHANVIEN> findAll(Pageable pageable);
}
