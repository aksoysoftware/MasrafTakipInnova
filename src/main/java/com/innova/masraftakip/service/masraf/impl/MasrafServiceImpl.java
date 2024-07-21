package com.innova.masraftakip.service.masraf.impl;

import com.innova.masraftakip.data.entity.Kisi;
import com.innova.masraftakip.data.entity.Masraf;
import com.innova.masraftakip.data.repository.KisiRepository;
import com.innova.masraftakip.data.repository.MasrafRepository;
import com.innova.masraftakip.dto.MasrafDto;
import com.innova.masraftakip.mapper.MasrafMapper;
import com.innova.masraftakip.service.masraf.MasrafService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasrafServiceImpl implements MasrafService {

    private final MasrafRepository masrafRepository;
    private final MasrafMapper masrafMapper;
    private final KisiRepository kisiRepository;

    public MasrafServiceImpl(MasrafRepository masrafRepository, MasrafMapper masrafMapper, KisiRepository kisiRepository) {
        this.masrafRepository = masrafRepository;
        this.masrafMapper = masrafMapper;
        this.kisiRepository = kisiRepository;
    }

    @Override
    public List<MasrafDto> getAllMasraflar() {
        List<Masraf> masrafList = masrafRepository.findAll();
        return masrafMapper.toDto(masrafList);
    }

    @Override
    public MasrafDto createMasraf(MasrafDto masrafDto) {
        Kisi kisi = kisiRepository.findById(Math.toIntExact(masrafDto.getKisiId())).orElseThrow(() -> new RuntimeException("Kisi not found"));
        Masraf masraf = masrafMapper.toEntity(masrafDto);
        masraf.setKisi(kisi);
        Masraf savedMasraf = masrafRepository.save(masraf);
        return masrafMapper.toDto(savedMasraf);
    }

    @Override
    public MasrafDto updateMasraf(Long id, MasrafDto masrafDto) {
        if (!masrafRepository.existsById(id)) {
            return null;
        }
        Kisi kisi = kisiRepository.findById(Math.toIntExact(masrafDto.getKisiId())).orElseThrow(() -> new RuntimeException("Kisi not found"));
        Masraf masraf = masrafMapper.toEntity(masrafDto);
        masraf.setId(id);
        masraf.setKisi(kisi);
        masraf = masrafRepository.save(masraf);
        return masrafMapper.toDto(masraf);
    }

    @Override
    public MasrafDto getMasrafById(Long id) {
        return masrafRepository.findById(id)
                .map(masrafMapper::toDto)
                .orElse(null);
    }

    @Override
    public void deleteMasraf(Long id) {
        if (masrafRepository.existsById(id)) {
            masrafRepository.deleteById(id);
        }
    }

    @Override
    public Double getTotalMasrafByKisiId(Long kisiId) {
        return masrafRepository.findTotalMasrafByKisiId(kisiId);
    }
}
