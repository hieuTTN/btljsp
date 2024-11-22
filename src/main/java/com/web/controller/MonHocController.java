package com.web.controller;

import com.web.entity.KhoaHoc;
import com.web.entity.MonHoc;
import com.web.repository.MonHocRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {

    @Autowired
    private MonHocRepository monHocRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSach(Model model) {
        model.addAttribute("listmonhoc", monHocRepository.findAll());
        return "monhoc";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("monhoc", new MonHoc());
        model.addAttribute("label", "Thêm môn học");
        if(id != null){
            model.addAttribute("monhoc", monHocRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật môn học");
        }
        return "addmonhoc";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute MonHoc monHoc, RedirectAttributes redirectAttributes) {
        monHocRepository.save(monHoc);
        redirectAttributes.addFlashAttribute("message", "Thêm môn học thành công!");
        return "redirect:/monhoc/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            monHocRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Môn học học đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa môn học thành công!");
        return "redirect:/monhoc/list";
    }
}
