package com.web.controller;

import com.web.entity.Khoa;
import com.web.entity.Nganh;
import com.web.repository.KhoaRepository;
import com.web.repository.NganhRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/nganh")
public class NganhController {

    @Autowired
    private KhoaRepository khoaRepository;

    @Autowired
    private NganhRepository nganhRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSach(Model model) {
        model.addAttribute("listnganh", nganhRepository.findAll());
        return "nganh";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("nganh", new Nganh());
        model.addAttribute("label", "Thêm ngành");
        if(id != null){
            model.addAttribute("nganh", nganhRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật ngành");
        }
        model.addAttribute("listkhoa", khoaRepository.findAll());
        return "addnganh";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute Nganh nganh, RedirectAttributes redirectAttributes) {
        nganhRepository.save(nganh);
        redirectAttributes.addFlashAttribute("message", "Thêm ngành thành công!");
        return "redirect:/nganh/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            nganhRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Ngành đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa ngành thành công!");
        return "redirect:/nganh/list";
    }
}
