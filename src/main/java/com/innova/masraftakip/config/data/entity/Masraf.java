package com.innova.masraftakip.config.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="MASRAF")
public class Masraf extends BaseEntity  {


    @Column(name = "MASRAF_ADI",columnDefinition = "varchar(255)")
    private String masrafAdi;

    @Column(name = "MASRAF_MIKTARI", columnDefinition = "double precision")
    private Double masrafMiktari;

    @ManyToOne
    @JoinColumn(name="KISI_ID", nullable=false)
    private Kisi kisi;
}