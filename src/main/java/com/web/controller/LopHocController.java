package com.web.controller;

import com.web.repository.LopHocRepository;
import com.web.repository.NganhRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lophoc")
public class LopHocController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private NganhRepository nganhRepository;
}
