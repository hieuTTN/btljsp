package com.web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String maSinhVien;

    private String hoTen;

    private Date ngaySinh;

    private String gioiTinh;

    private String anh;

    private String diaChi;

    private String noiSinh;

    @ManyToOne
    private LopHoc lopHoc;
}
