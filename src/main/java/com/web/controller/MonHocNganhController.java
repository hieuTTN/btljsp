package com.web.controller;

import com.web.repository.MonHocNganhRepository;
import com.web.repository.MonHocRepository;
import com.web.repository.NganhRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monhoc-nganh")
public class MonHocNganhController {

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private MonHocNganhRepository monHocNganhRepository;

    @Autowired
    private NganhRepository nganhRepository;
}
