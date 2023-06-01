package com.bai3.bai5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table (name="phongban")
public class PHONGBAN {
    @Id
    @Size(max= 2,message = "max 2 characters")
    private String Ma_Phong;
    @NotBlank
    @Size(max= 100,message = "max 100 characters")
    @Column(name = "Ten_Phong")
    private String Ten_Phong;
    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<NHANVIEN> nhanvien;
}
