package com.innova.masraftakip.config.data.repository;

import com.innova.masraftakip.config.data.entity.Masraf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MasrafRepository extends JpaRepository<Masraf,Long> {

    @Query("SELECT SUM(m.masrafMiktari) FROM Masraf m WHERE m.kisi.id = :kisiId")
    Double findTotalMasrafByKisiId(Long kisiId);
}
