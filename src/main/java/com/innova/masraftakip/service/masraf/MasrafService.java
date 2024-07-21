package com.innova.masraftakip.service.masraf;

import com.innova.masraftakip.dto.KisiDto;
import com.innova.masraftakip.dto.MasrafDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MasrafService {

    List<MasrafDto> getAllMasraflar();

    MasrafDto createMasraf(MasrafDto masrafDto);

    MasrafDto updateMasraf(Long id, MasrafDto masrafDto);


    MasrafDto getMasrafById(Long id);

    void deleteMasraf(Long id);
}
