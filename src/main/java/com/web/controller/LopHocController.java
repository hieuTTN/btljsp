package com.web.controller;

import com.web.entity.LopHoc;
import com.web.entity.Nganh;
import com.web.repository.KhoaHocRepository;
import com.web.repository.LopHocRepository;
import com.web.repository.NganhRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lophoc")
public class LopHocController {

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private NganhRepository nganhRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSach(Model model) {
        model.addAttribute("listlop", lopHocRepository.findAll());
        return "lophoc";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("lophoc", new LopHoc());
        model.addAttribute("label", "Thêm lớp học");
        if(id != null){
            model.addAttribute("lophoc", lopHocRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật lớp học");
        }
        model.addAttribute("listnganh", nganhRepository.findAll());
        model.addAttribute("listkhoahoc", khoaHocRepository.findAll());
        return "addlophoc";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute LopHoc lopHoc, RedirectAttributes redirectAttributes) {
        lopHocRepository.save(lopHoc);
        redirectAttributes.addFlashAttribute("message", "Thêm lớp học thành công!");
        return "redirect:/lophoc/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            lopHocRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Lóp học đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa lớp học thành công!");
        return "redirect:/lophoc/list";
    }
}
