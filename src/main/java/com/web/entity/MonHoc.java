package com.web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mon_hoc")
@Getter
@Setter
public class MonHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String maMon;

    private String tenMon;

    private Float soTinChi;

    private Float soTinLyThuyet;

    private Float soTinThucHanh;

    private Integer tongSoTiet;
}
