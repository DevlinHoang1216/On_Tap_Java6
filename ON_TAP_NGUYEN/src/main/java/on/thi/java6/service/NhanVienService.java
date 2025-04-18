package on.thi.java6.service;

import on.thi.java6.dto.NhanVienCustom;
import on.thi.java6.dto.NhanVienDTO;
import on.thi.java6.entity.NhanVien;
import on.thi.java6.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVienCustom> getAll() {
        return nhanVienRepository.getAllNhanVien();
    }

    public Page<NhanVienCustom> getAllNhanVien(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return nhanVienRepository.findAllNhanVienCustom(pageable);
    }

    public NhanVien add(NhanVienDTO request) {
        NhanVien nhanVien = request.dto(new NhanVien() );
        return nhanVienRepository.save(nhanVien);
    }

    public Boolean delete(Long id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        if (optional.isPresent()) {
            NhanVien nhanVien = optional.get();
            nhanVienRepository.delete(nhanVien);
            return true;
        }else {
            return false;
        }

    }

    public NhanVien findById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public NhanVien update(Long id, NhanVienDTO request) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
        if (nhanVien == null) return null; // Nếu không tìm thấy thì trả null

        request.dto(nhanVien); // Gán dữ liệu từ DTO vào entity cũ
        return nhanVienRepository.save(nhanVien); // Lưu và trả về entity đã cập nhật
    }

    public List<NhanVienCustom> locNhanVien() {
        return nhanVienRepository.findByTenContainsAndTuoiGreater("a", 18);
    }


}
