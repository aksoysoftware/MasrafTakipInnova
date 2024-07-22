package com.innova.masraftakip.dto;


import com.innova.masraftakip.enums.Durum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KisiDto {
    private String ad;
    private String soyAd;
    private Durum durum;
}
