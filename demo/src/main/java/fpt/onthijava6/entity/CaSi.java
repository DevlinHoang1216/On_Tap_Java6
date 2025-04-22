package fpt.onthijava6.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ca_si")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_ca_si")
    private String tenCaSi;

    @Column(name = "que_quan")
    private String queQuan;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
}
