package com.innova.masraftakip.service.kisi;

import com.innova.masraftakip.dto.KisiDto;

import java.util.List;

public interface KisiService {

    List<KisiDto> getAllKisiler();

    KisiDto getKisiById(Long id);

    KisiDto createKisi(KisiDto kisiDTO);

    KisiDto updateKisi(Long id, KisiDto kisiDTO);

    void deleteKisi(Long id);
}
