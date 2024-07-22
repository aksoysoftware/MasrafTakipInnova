package com.innova.masraftakip.data.repository;

import com.innova.masraftakip.data.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KisiRepository extends JpaRepository<Kisi, Long> {


    Optional<Object> findByKullaniciAdi(String kullaniciAdi);
}
