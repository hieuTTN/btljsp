package com.web.controller;

import com.web.repository.NganhRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nganh")
public class NganhController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private NganhRepository nganhRepository;
}
