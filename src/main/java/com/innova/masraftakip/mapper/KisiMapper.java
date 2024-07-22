package com.innova.masraftakip.mapper;

import com.innova.masraftakip.config.data.entity.Kisi;
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
        dto.setId(entity.getId());
        dto.setAd(entity.getAd());
        dto.setSoyAd(entity.getSoyAd());

        return dto;
    }

    @Override
    public Kisi toEntity(KisiDto dto) {
        if (dto == null) {
            return null;
        }

        Kisi entity = new Kisi();
        entity.setId(dto.getId());
        entity.setAd(dto.getAd());
        entity.setSoyAd(dto.getSoyAd());
        return entity;
    }
}
