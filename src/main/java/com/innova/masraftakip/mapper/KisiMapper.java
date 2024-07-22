package com.innova.masraftakip.mapper;

import com.innova.masraftakip.data.entity.Kisi;
import com.innova.masraftakip.dto.KisiDto;
import org.springframework.stereotype.Component;

@Component
public class KisiMapper implements BaseMapper<Kisi, KisiDto> {

    @Override
    public KisiDto toDto(Kisi entity) {
        if (entity == null) {
            return null;
        }

        KisiDto dto = new KisiDto();
        dto.setAd(entity.getAd());
        dto.setSoyAd(entity.getSoyAd());
        dto.setDurum(entity.getDurum());

        return dto;
    }

    @Override
    public Kisi toEntity(KisiDto dto) {
        if (dto == null) {
            return null;
        }

        Kisi entity = new Kisi();
        entity.setAd(dto.getAd());
        entity.setSoyAd(dto.getSoyAd());
        entity.setDurum(dto.getDurum());

        return entity;
    }
}
