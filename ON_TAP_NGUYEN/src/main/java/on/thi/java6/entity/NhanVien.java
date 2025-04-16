package on.thi.java6.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ma_nhan_vien")
    private String maNhanVien;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;


    @ManyToOne
    @JoinColumn(name = "id_chuc_vu")
    private ChucVu idChucVu;
}

