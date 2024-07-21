package com.innova.masraftakip.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="KISI")
public class Kisi extends BaseEntity  {


    @Column(name = "AD",columnDefinition = "varchar(255)")
    private String ad;

    @Column(name = "SOYAD",columnDefinition = "varchar(255)")
    private String soyAd;

}
