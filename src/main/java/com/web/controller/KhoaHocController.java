package com.web.controller;

import com.web.entity.KhoaHoc;
import com.web.repository.KhoaHocRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSachKhoaHoc(Model model) {
        model.addAttribute("listkhoahoc", khoaHocRepository.findAll());
        return "khoahoc";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("khoahoc", new KhoaHoc());
        model.addAttribute("label", "Thêm khóa học");
        if(id != null){
            model.addAttribute("khoahoc", khoaHocRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật khóa học");
        }
        return "addkhoahoc";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute KhoaHoc khoaHoc, RedirectAttributes redirectAttributes) {
        khoaHocRepository.save(khoaHoc);
        redirectAttributes.addFlashAttribute("message", "Thêm khóa học thành công!");
        return "redirect:/khoahoc/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            khoaHocRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Khóa học đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa khóa học thành công!");
        return "redirect:/khoahoc/list";
    }
}
