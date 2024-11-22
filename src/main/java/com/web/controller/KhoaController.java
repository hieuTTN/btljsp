package com.web.controller;

import com.web.entity.Khoa;
import com.web.entity.KhoaHoc;
import com.web.repository.KhoaRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/khoa")
public class KhoaController {

    @Autowired
    private KhoaRepository khoaRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSachKhoaHoc(Model model) {
        model.addAttribute("listkhoa", khoaRepository.findAll());
        return "khoa";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("khoa", new Khoa());
        model.addAttribute("label", "Thêm khoa");
        if(id != null){
            model.addAttribute("khoa", khoaRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật khoa");
        }
        return "addkhoa";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute Khoa khoa, RedirectAttributes redirectAttributes) {
        khoaRepository.save(khoa);
        redirectAttributes.addFlashAttribute("message", "Thêm khoa thành công!");
        return "redirect:/khoa/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            khoaRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Khoa đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa khoa thành công!");
        return "redirect:/khoa/list";
    }
}
