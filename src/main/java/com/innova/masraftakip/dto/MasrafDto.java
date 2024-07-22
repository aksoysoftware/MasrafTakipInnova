package com.innova.masraftakip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasrafDto {

    private String masrafAdi;
    private Double masrafMiktari;
    private Long kisiId;
}
