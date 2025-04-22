package fpt.onthijava6.dto;

import fpt.onthijava6.entity.BaiHat;
import fpt.onthijava6.entity.CaSi;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BaiHatCustom {
    @NotBlank(message = "Ten Bai Hat Khong Duoc De Trong")
    private String tenBaiHat;
    @NotBlank(message = "Ten Tac Gia Khong Duoc De Trong")
    private String tenTacGia;
    @NotNull(message = "Ngay Ra Mat Khong Duoc De Trong")
    private LocalDate ngayRaMat;
    @NotNull(message = "Id Ca Si Khong Duoc De Trong")
    private Long idCaSi;


    public BaiHat dtoToBaiHat(BaiHat baiHat) {
        baiHat.setTenBaiHat(this.getTenBaiHat());
        baiHat.setTenTacGia(this.getTenTacGia());
        baiHat.setNgayRaMat(this.getNgayRaMat());
        baiHat.setIdCaSi(CaSi.builder().id(this.getIdCaSi()).build());
        return baiHat;
    }
}
