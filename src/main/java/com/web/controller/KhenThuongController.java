package com.web.controller;

import com.web.repository.KhenThuongRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khenthuong")
public class KhenThuongController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private KhenThuongRepository khenThuongRepository;
}
