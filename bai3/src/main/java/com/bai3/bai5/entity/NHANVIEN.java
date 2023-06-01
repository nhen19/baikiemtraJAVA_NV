package com.bai3.bai5.entity;

import com.bai3.bai5.validator.annotation.ValidCategoryID;
import com.bai3.bai5.validator.annotation.ValidUsername_Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.validation.constraints.Max;

@Getter @Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table (name="nhanvien")
public class NHANVIEN {
    @Id
    @NotBlank
    @Size(max= 3,message = "max 3 characters")
    private String Ma_NV;
    @NotBlank(message = "This field is required")
    @Size(max= 100,message = "max 100 characters")
    @Column(name = "Ten_NV")
    private String Ten_NV;
    @Size(max= 3,message = "max 3 characters")
    private String Phai;
    @Size(max= 200,message = "max 200 characters")
    @Column(name = "Noi_Sinh")
    private String Noi_Sinh;
    @Column(name = "Luong")
    private int Luong;


    @ManyToOne
    @JoinColumn(name="Ma_Phong")
    @ValidCategoryID
    private PHONGBAN phongban;
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ValidUsername_Book
//    private User user;

}
