package com.web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "diem")
@Getter
@Setter
public class Diem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Float diem;

    @ManyToOne
    private MonHocNganh monHocNganh;

    @ManyToOne
    private SinhVien sinhVien;
}
