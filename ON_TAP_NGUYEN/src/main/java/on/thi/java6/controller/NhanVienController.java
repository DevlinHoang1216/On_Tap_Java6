package on.thi.java6.controller;

import jakarta.validation.Valid;
import on.thi.java6.dto.NhanVienDTO;
import on.thi.java6.entity.NhanVien;
import on.thi.java6.repository.ChucVuRepository;
import on.thi.java6.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanvienService;




    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nhanvienService.getAll());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam (defaultValue = "0", name = "page")Integer page) {
        return ResponseEntity.ok(nhanvienService.getAllNhanVien(page));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addNhanVien(@RequestBody @Valid NhanVienDTO request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(nhanvienService.add(request));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (nhanvienService.delete(id)){
            return ResponseEntity.ok("Xoa thành công");
        }else {
            return ResponseEntity.ok("Xóa thất bại");
        }
    }
}
