package com.innova.masraftakip.mapper;

import com.innova.masraftakip.data.entity.Masraf;
import com.innova.masraftakip.dto.MasrafDto;
import org.springframework.stereotype.Component;

@Component
public class MasrafMapper implements BaseMapper<Masraf, MasrafDto> {

    @Override
    public MasrafDto toDto(Masraf entity) {
        if (entity == null) {
            return null;
        }

        MasrafDto masrafDto = new MasrafDto();
        masrafDto.setId(entity.getId());
        masrafDto.setMasrafAdi(entity.getMasrafAdi());
        masrafDto.setMasrafMiktari(entity.getMasrafMiktari());
        masrafDto.setKisiId(entity.getKisi().getId());

        return masrafDto;
    }

    @Override
    public Masraf toEntity(MasrafDto dto) {
        if (dto == null) {
            return null;
        }

        Masraf masraf = new Masraf();
        masraf.setId(dto.getId());
        masraf.setMasrafAdi(dto.getMasrafAdi());
        masraf.setMasrafMiktari(dto.getMasrafMiktari());
        //kisi set et

        return masraf;
    }
}
