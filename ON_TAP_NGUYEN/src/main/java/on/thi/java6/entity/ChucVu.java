package on.thi.java6.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chuc_vu")
@Builder
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ma_chuc_vu")
    private String maChucVu;
    @Column(name = "ten_chuc_vu")
    private String tenChucVu;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "he_so_luong")
    private Float heSoLuong;

}
