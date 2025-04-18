package on.thi.java6.repository;

import on.thi.java6.dto.NhanVienCustom;
import on.thi.java6.entity.ChucVu;
import on.thi.java6.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Query(value = "select nv.id,nv.ma_nhan_vien,nv.ho_ten,nv.gioi_tinh,nv.ngay_sinh, cv.ma_chuc_vu,cv.ten_chuc_vu \n" +
            "from nhan_vien nv join chuc_vu cv on nv.id_chuc_vu = cv.id", nativeQuery = true)
    List<NhanVienCustom>getAllNhanVien();

    @Query(value = "select nv.id,nv.ma_nhan_vien,nv.ho_ten,nv.gioi_tinh,nv.ngay_sinh, cv.ma_chuc_vu,cv.ten_chuc_vu \n" +
            "from nhan_vien nv join chuc_vu cv on nv.id_chuc_vu = cv.id",
            countQuery = "select count(*) from nhan_vien nv join chuc_vu cv on nv.id_chuc_vu = cv.id"
            ,nativeQuery = true)
    Page<NhanVienCustom> findAllNhanVienCustom(Pageable pageable);


    @Query(value = "SELECT nv.id, nv.ma_nhan_vien, nv.ho_ten, nv.gioi_tinh, nv.ngay_sinh, " +
            "cv.ma_chuc_vu, cv.ten_chuc_vu " +
            "FROM nhan_vien nv " +
            "JOIN chuc_vu cv ON nv.id_chuc_vu = cv.id " +
            "WHERE LOWER(nv.ho_ten) LIKE %:keyword% " +
            "AND DATEDIFF(YEAR, nv.ngay_sinh, GETDATE()) >= :minAge",
            nativeQuery = true)
    List<NhanVienCustom> findByTenContainsAndTuoiGreater(String keyword, int minAge);
}
