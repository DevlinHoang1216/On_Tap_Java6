package on.thi.java6.dto;

import java.time.LocalDate;

public interface NhanVienCustom {
    Long getId();

    String getMaNhanVien();

    String getHoTen();

    LocalDate getNgaySinh();

    Boolean getGioiTinh();

    String getMaChucVu();

    String getTenChucVu();

}
