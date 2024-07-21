package com.innova.masraftakip.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="masraf")
public class Masraf extends BaseEntity  {


    @Column(name = "masraf_adi",columnDefinition = "varchar(255)")
    private String masraf_adi;

    @Column(name = "masraf_miktari",columnDefinition = "integer")
    private int masraf_miktari;

    @ManyToOne
    @JoinColumn(name="kisi_id", nullable=false)
    private Kisi kisi;
}