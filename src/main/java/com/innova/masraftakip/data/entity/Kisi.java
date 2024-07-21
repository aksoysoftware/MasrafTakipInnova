package com.innova.masraftakip.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "KISI")
public class Kisi extends BaseEntity {

    @Column(name = "AD", columnDefinition = "varchar(255)")
    private String ad;

    @Column(name = "SOYAD", columnDefinition = "varchar(255)")
    private String soyAd;

    @Column(name = "KULLANICI_ADI")
    private String kullaniciAdi;

    @Column(name = "SIFRE")
    private String sifre;

    @Column(name = "EMAIL")
    private String email;
}
