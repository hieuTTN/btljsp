package com.web.controller;

import com.web.repository.KhoaRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khoa")
public class KhoaController {

    @Autowired
    private KhoaRepository khoaRepository;
}
