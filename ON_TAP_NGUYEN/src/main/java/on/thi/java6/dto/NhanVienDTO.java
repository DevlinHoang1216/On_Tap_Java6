package on.thi.java6.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import on.thi.java6.entity.ChucVu;
import on.thi.java6.entity.NhanVien;

import java.time.LocalDate;

@Getter
@Setter
public class NhanVienDTO {
    @NotBlank(message = "Ma khong duoc de trong")
    private String maNhanVien;

    @NotBlank(message = "Ten khong duoc de trong")
    private String hoTen;

    @NotNull(message = "Ngay sinh khong duoc de trong")
    private LocalDate ngaySinh;

    @NotBlank(message = "Gioi tinh khong duoc de trong")
    private String gioiTinh;

    @NotNull(message = "Ma Chuc Vu khong duoc de trong")
    private Long idChucVu;


    public NhanVien dto(NhanVien nhanVien) {
        nhanVien.setMaNhanVien(this.getMaNhanVien());
        nhanVien.setHoTen(this.getHoTen());
        nhanVien.setNgaySinh(this.getNgaySinh());
        nhanVien.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        nhanVien.setIdChucVu(ChucVu.builder().id(this.idChucVu).build());
        return nhanVien;
    }
}

