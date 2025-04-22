package fpt.onthijava6.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_bai_hat")
    private String tenBaiHat;

    @Column(name = "ten_tac_gia")
    private String tenTacGia;

    @Column(name = "ngay_ra_mat")
    private LocalDate ngayRaMat;

    @ManyToOne
    @JoinColumn(name = "ca_si_id",nullable = false)
    private CaSi idCaSi;
}
