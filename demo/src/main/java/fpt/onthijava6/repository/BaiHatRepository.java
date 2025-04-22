package fpt.onthijava6.repository;

import fpt.onthijava6.dto.BaiHatDTO;
import fpt.onthijava6.entity.BaiHat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat,Long> {
    @Query(value = "Select bh.id, bh.ten_bai_hat, bh.ten_tac_gia, bh.ngay_ra_mat, cs.ten_ca_si, cs.que_quan, cs.sdt,cs.gioi_tinh\n" +
            "From bai_hat bh join ca_si cs on bh.ca_si_id = cs.id",nativeQuery = true)
    List<BaiHatDTO> findAllBaiHats();

    @Query(value = "Select bh.id, bh.ten_bai_hat, bh.ten_tac_gia, bh.ngay_ra_mat, cs.ten_ca_si, cs.que_quan, cs.sdt,cs.gioi_tinh\n" +
            "From bai_hat bh join ca_si cs on bh.ca_si_id = cs.id"
            ,nativeQuery = true)
    Page<BaiHatDTO> findAllBaiHatPhanTrang(Pageable pageable);

    @Query(value = "Select bh.id, bh.ten_bai_hat, bh.ten_tac_gia, bh.ngay_ra_mat, cs.ten_ca_si, cs.que_quan, cs.sdt,cs.gioi_tinh\n" +
            "From bai_hat bh join ca_si cs on bh.ca_si_id = cs.id\n" +
            "Where cs.gioi_tinh = 0 \n" +
            "Order by bh.ngay_ra_mat ASC"
            ,nativeQuery = true)
    List<BaiHatDTO> getFemaleCaSi();

    @Query(value = "Select bh.id, bh.ten_bai_hat, bh.ten_tac_gia, bh.ngay_ra_mat, cs.ten_ca_si, cs.que_quan, cs.sdt,cs.gioi_tinh\n" +
            "From bai_hat bh join ca_si cs on bh.ca_si_id = cs.id\n" +
            "Where cs.gioi_tinh = 0 \n" +
            "Order by bh.ngay_ra_mat ASC"
            ,nativeQuery = true)
    List<BaiHatDTO> timBanNuLonTuoiNhat(Pageable pageable);


    @Query(value = "Select bh.id, bh.ten_bai_hat, bh.ten_tac_gia, bh.ngay_ra_mat, cs.ten_ca_si, cs.que_quan, cs.sdt,cs.gioi_tinh\n" +
            "From bai_hat bh join ca_si cs on bh.ca_si_id = cs.id\n" +
            "Where cs.gioi_tinh = 0 \n" +
            "Order by bh.ngay_ra_mat ASC"
            ,nativeQuery = true)
    List<BaiHatDTO> findAllOrderByNgayBaiHatAnd();

}
