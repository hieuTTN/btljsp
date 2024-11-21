package com.web.controller;

import com.web.repository.KhoaHocRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private KhoaHocRepository khoaHocRepository;
}
