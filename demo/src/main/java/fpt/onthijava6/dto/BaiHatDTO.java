package fpt.onthijava6.dto;

import java.time.LocalDate;

public interface BaiHatDTO {

    Long getId();
    String getTenBaiHat();
    String getTenTacGia();
    LocalDate getNgayRaMat();
    String getTenCaSi();
    String getQueQuan();
    String getSdt();
    boolean getGioiTinh();
}
