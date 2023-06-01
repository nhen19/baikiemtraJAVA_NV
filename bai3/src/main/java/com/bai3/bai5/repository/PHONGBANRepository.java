package com.bai3.bai5.repository;

import com.bai3.bai5.entity.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PHONGBANRepository extends JpaRepository<PHONGBAN, String> {

}
