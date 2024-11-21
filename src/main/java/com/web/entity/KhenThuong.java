package com.web.entity;

import com.web.enums.LoaiKhenThuong;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "khen_thuong")
@Getter
@Setter
public class KhenThuong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date ngayKhenThuong;

    @Enumerated(EnumType.STRING)
    private LoaiKhenThuong loaiKhenThuong;

    private String moTa;

    private Integer soTienKhenThuong;

    @ManyToOne
    private SinhVien sinhVien;
}
