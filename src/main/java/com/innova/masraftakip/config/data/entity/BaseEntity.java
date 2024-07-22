package com.innova.masraftakip.config.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "OLUSTURMA_TARIHI", nullable = false, updatable = false)
    private Timestamp olusturmaTarihi;

    @Column(name = "GUNCELLEME_TARIHI", nullable = false)
    private Timestamp guncellemeTarihi;

    public BaseEntity() {
        this.olusturmaTarihi = new Timestamp(System.currentTimeMillis());
        this.guncellemeTarihi = new Timestamp(System.currentTimeMillis());
    }
}
