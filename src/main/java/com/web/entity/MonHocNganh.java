package com.web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mon_hoc_nganh")
@Getter
@Setter
public class MonHocNganh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private MonHoc monHoc;

    @ManyToOne
    private Nganh nganh;
}
