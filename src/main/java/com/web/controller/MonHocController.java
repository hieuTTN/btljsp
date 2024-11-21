package com.web.controller;

import com.web.repository.MonHocRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {

    @Autowired
    private MonHocRepository monHocRepository;

}
