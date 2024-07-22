package com.innova.masraftakip.service.masraf.impl;

import com.innova.masraftakip.data.entity.Kisi;
import com.innova.masraftakip.data.entity.Masraf;
import com.innova.masraftakip.data.repository.KisiRepository;
import com.innova.masraftakip.data.repository.MasrafRepository;
import com.innova.masraftakip.dto.MasrafDto;
import com.innova.masraftakip.mapper.MasrafMapper;
import com.innova.masraftakip.service.background.AuditService;
import com.innova.masraftakip.service.masraf.MasrafService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasrafServiceImpl implements MasrafService {

    private final MasrafRepository masrafRepository;
    private final MasrafMapper masrafMapper;
    private final KisiRepository kisiRepository;
    private final AuditService auditService;

    public MasrafServiceImpl(MasrafRepository masrafRepository, MasrafMapper masrafMapper, KisiRepository kisiRepository, AuditService auditService) {
        this.masrafRepository = masrafRepository;
        this.masrafMapper = masrafMapper;
        this.kisiRepository = kisiRepository;
        this.auditService = auditService;
    }

    @Override
    public List<MasrafDto> getAllMasraflar() {
        List<Masraf> masrafList = masrafRepository.findAll();
        auditService.logAction("GET_ALL_MASRAFLAR", "Fetched all Masraflar");
        return masrafMapper.toDto(masrafList);
    }

    @Transactional
    @Override
    public MasrafDto createMasraf(MasrafDto masrafDto) {
        Kisi kisi = kisiRepository.findById(masrafDto.getKisiId()).orElseThrow(() -> new RuntimeException("Kisi not found"));
        Masraf masraf = masrafMapper.toEntity(masrafDto);
        masraf.setKisi(kisi);
        Masraf savedMasraf = masrafRepository.save(masraf);
        auditService.logAction("CREATE_MASRAF", "Created Masraf with id: " + savedMasraf.getId());
        return masrafMapper.toDto(savedMasraf);
    }

    @Transactional
    @Override
    public MasrafDto updateMasraf(Long id, MasrafDto masrafDto) {
        if (!masrafRepository.existsById(id)) {
            auditService.logAction("UPDATE_MASRAF", "Masraf not found with id: " + id);
            return null;
        }
        Kisi kisi = kisiRepository.findById(masrafDto.getKisiId()).orElseThrow(() -> new RuntimeException("Kisi not found"));
        Masraf masraf = masrafMapper.toEntity(masrafDto);
        masraf.setId(id);
        masraf.setKisi(kisi);
        masraf = masrafRepository.save(masraf);
        auditService.logAction("UPDATE_MASRAF", "Updated Masraf with id: " + masraf.getId());
        return masrafMapper.toDto(masraf);
    }

    @Override
    public MasrafDto getMasrafById(Long id) {
        MasrafDto masrafDto = masrafRepository.findById(id)
                .map(masrafMapper::toDto)
                .orElse(null);
        auditService.logAction("GET_MASRAF_BY_ID", masrafDto != null ? "Masraf found with id: " + id : "Masraf not found with id: " + id);
        return masrafDto;
    }

    @Override
    public void deleteMasraf(Long id) {
        if (masrafRepository.existsById(id)) {
            masrafRepository.deleteById(id);
            auditService.logAction("DELETE_MASRAF", "Deleted Masraf with id: " + id);
        } else {
            auditService.logAction("DELETE_MASRAF", "Masraf not found with id: " + id);
        }
    }

    @Override
    public Double getTotalMasrafByKisiId(Long kisiId) {
        Double totalMasraf = masrafRepository.findTotalMasrafByKisiId(kisiId);
        auditService.logAction("GET_TOTAL_MASRAF_BY_KISI_ID", "Total masraf for kisiId: " + kisiId + " is " + totalMasraf);
        return totalMasraf;
    }
}
