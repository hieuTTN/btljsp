package com.web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lop_hoc")
@Getter
@Setter
public class LopHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String maLop;

    private String ten;

    @ManyToOne
    private Nganh nganh;

    @ManyToOne
    private KhoaHoc khoaHoc;
}
