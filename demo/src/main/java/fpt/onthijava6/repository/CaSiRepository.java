package fpt.onthijava6.repository;

import fpt.onthijava6.entity.CaSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, Long> {
}
