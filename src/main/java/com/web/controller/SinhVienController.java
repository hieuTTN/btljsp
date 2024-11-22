package com.web.controller;

import com.web.entity.LopHoc;
import com.web.entity.SinhVien;
import com.web.repository.LopHocRepository;
import com.web.repository.SinhVienRepository;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    ServletContext context;


    @Value("${image.upload.dir}")
    private String uploadDir;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String danhSach(Model model) {
        model.addAttribute("listsinhvien", sinhVienRepository.findAll());
        return "sinhvien";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addView(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("sinhvien", new SinhVien());
        model.addAttribute("label", "Thêm sinh viên");
        if(id != null){
            model.addAttribute("sinhvien", sinhVienRepository.findById(id).get());
            model.addAttribute("label", "Cập nhật sinh viên");
        }
        model.addAttribute("listlop", lopHocRepository.findAll());
        return "addsinhvien";
    }

    @PostMapping(value = {"/add"})
    public String addHoacUpdate(@ModelAttribute SinhVien sinhVien, RedirectAttributes redirectAttributes,@RequestParam(value = "image", required = false) MultipartFile image) {
        String anh = linkAnh(image);
        if(sinhVien.getId() != null){
            SinhVien ex = sinhVienRepository.findById(sinhVien.getId()).get();
            if(anh.equals("")){
                anh = ex.getAnh();
            }
        }
        sinhVien.setAnh(anh);
        sinhVienRepository.save(sinhVien);
        redirectAttributes.addFlashAttribute("message", "Thêm sinh viên thành công!");
        return "redirect:/sinhvien/list";
    }


    @GetMapping(value = {"/delete"})
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            sinhVienRepository.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Lóp học đã có liên kết, không thể xóa!");
        }
        redirectAttributes.addFlashAttribute("message", "Xóa lớp học thành công!");
        return "redirect:/lophoc/list";
    }

    public String linkAnh(MultipartFile file){
        try {
            if (!file.isEmpty()) {
                String fileOriginal = file.getOriginalFilename();
                String fileDest = context.getRealPath("/image/" + fileOriginal);
                file.transferTo(new File(fileDest));
                System.out.println("Lưu ảnh thành công !");
                return fileOriginal;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
