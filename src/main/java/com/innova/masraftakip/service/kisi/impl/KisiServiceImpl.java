package com.innova.masraftakip.service.kisi.impl;

import com.innova.masraftakip.config.data.entity.Kisi;
import com.innova.masraftakip.config.data.repository.KisiRepository;
import com.innova.masraftakip.dto.KisiDto;
import com.innova.masraftakip.mapper.KisiMapper;
import com.innova.masraftakip.service.kisi.KisiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final KisiMapper kisiMapper;

    public KisiServiceImpl(KisiRepository kisiRepository, KisiMapper kisiMapper) {
        this.kisiRepository = kisiRepository;
        this.kisiMapper = kisiMapper;
    }

    @Override
    public List<KisiDto> getAllKisiler() {
        List<Kisi> kisiler = kisiRepository.findAll();
        return kisiMapper.toDto(kisiler);
    }

    @Override
    public KisiDto getKisiById(Long id) {
        return kisiRepository.findById(id)
                .map(kisiMapper::toDto)
                .orElse(null);
    }

    @Override
    public KisiDto createKisi(KisiDto kisiDto) {
        Kisi kisi = kisiMapper.toEntity(kisiDto);
        kisi = kisiRepository.save(kisi);
        return kisiMapper.toDto(kisi);
    }

    @Override
    public KisiDto updateKisi(Long id, KisiDto kisiDto) {
        if (!kisiRepository.existsById(id)) {
            return null;
        }
        Kisi kisi = kisiMapper.toEntity(kisiDto);
        kisi.setId(id);
        kisi = kisiRepository.save(kisi);
        return kisiMapper.toDto(kisi);
    }

    @Override
    public void deleteKisi(Long id) {
        if (kisiRepository.existsById(id)) {
            kisiRepository.deleteById(id);
        }
    }
}
