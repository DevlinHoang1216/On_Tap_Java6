package fpt.onthijava6.controller;

import fpt.onthijava6.dto.BaiHatCustom;
import fpt.onthijava6.dto.BaiHatDTO;
import fpt.onthijava6.entity.BaiHat;
import fpt.onthijava6.service.BaiHatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/baiHat")
public class BaiHatController {

    @Autowired
    BaiHatService baiHatService;

    @GetMapping("/hien-thi")
    public List<BaiHatDTO> getBaiHat() {
        return baiHatService.getAllBaiHat();
    }

    @GetMapping("/phan-trang")
    public ResponseEntity<?> phanTrang(@RequestParam(defaultValue = "0", name = "page")Integer page) {
     return ResponseEntity.ok(baiHatService.getBaiHatByPage(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBaiHat(@RequestBody @Valid BaiHatCustom request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(baiHatService.add(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBaiHat(@RequestBody BaiHatCustom request, @PathVariable("id") Long id){
        BaiHat updated = baiHatService.update(id,request);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getNhanVienById(@PathVariable("id") Long id){
        BaiHat bh = baiHatService.findById(id);
        if(bh != null){
            return ResponseEntity.ok(bh);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/sap-xep")
    public ResponseEntity<?> getSapXep(){
        return ResponseEntity.ok(baiHatService.getFemaleBaiHat());
    }

    @GetMapping("/ngay-ra-mat-lau-nhat")
    public BaiHatDTO getNgayRaMatLauNhatLaNu(){
        return baiHatService.timNgayRaMatLauNhatLaNu();
    }


    @GetMapping("/nhom-theo-thang-ra-mat")
    public Map<Integer, List<BaiHatDTO>> getNhomTheoThangRaMat(){
        return baiHatService.nhomTheoThangRaMatVaSapXep();
    }
}
