package com.web.controller;

import com.web.entity.KhenThuong;
import com.web.entity.SinhVien;
import com.web.repository.KhenThuongRepository;
import com.web.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/khenthuong")
public class KhenThuongController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private KhenThuongRepository khenThuongRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSach(Model model) {
        model.addAttribute("listkhenthuong", khenThuongRepository.findAll());
        return "khenthuong";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("khenthuong", new KhenThuong());
        model.addAttribute("label", "Thêm khen thưởng");
        if(id != null){
            model.addAttribute("khenthuong", khenThuongRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật khen thưởng");
        }
        model.addAttribute("listsinhvien", sinhVienRepository.findAll());
        return "addkhenthuong";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute KhenThuong khenThuong, RedirectAttributes redirectAttributes, @RequestParam(value = "image", required = false) MultipartFile image) {
        khenThuongRepository.save(khenThuong);
        redirectAttributes.addFlashAttribute("message", "Thêm khen thưởng thành công!");
        return "redirect:/khenthuong/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            khenThuongRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Khen thưởng đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa khen thưởng thành công!");
        return "redirect:/khenthuong/list";
    }
}
