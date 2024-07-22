package com.innova.masraftakip.data.entity;


import com.innova.masraftakip.enums.Durum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "KISI")
//@Where(clause = "DURUM = 'AKTIF'")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "kisi_rol",
            joinColumns = @JoinColumn(name = "kisi_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roller;


    @Enumerated(EnumType.STRING)
    @Column(name = "DURUM")
    private Durum durum;
}
