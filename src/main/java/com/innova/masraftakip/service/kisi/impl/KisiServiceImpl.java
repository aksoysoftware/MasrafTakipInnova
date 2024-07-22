package com.innova.masraftakip.service.kisi.impl;

import com.innova.masraftakip.data.entity.Kisi;
import com.innova.masraftakip.data.repository.KisiRepository;
import com.innova.masraftakip.dto.KisiDto;
import com.innova.masraftakip.enums.Durum;
import com.innova.masraftakip.mapper.KisiMapper;
import com.innova.masraftakip.service.background.AuditService;
import com.innova.masraftakip.service.kisi.KisiService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final KisiMapper kisiMapper;
    private final AuditService auditService;

    public KisiServiceImpl(KisiRepository kisiRepository, KisiMapper kisiMapper, AuditService auditService) {
        this.kisiRepository = kisiRepository;
        this.kisiMapper = kisiMapper;
        this.auditService = auditService;
    }

    @Override
    public List<KisiDto> getAllKisiler() {
        List<Kisi> kisiler = kisiRepository.findAll();
        auditService.logAction("GET_ALL_KISILER", "Fetched all Kisiler");
        return kisiMapper.toDto(kisiler);
    }

    @Override
    public KisiDto getKisiById(Long id) {
        KisiDto kisiDto = kisiRepository.findById(id)
                .map(kisiMapper::toDto)
                .orElse(null);
        auditService.logAction("GET_KISI_BY_ID", kisiDto != null ? "Kisi found with id: " + id : "Kisi not found with id: " + id);
        return kisiDto;
    }

    @Transactional
    @Override
    public KisiDto createKisi(KisiDto kisiDto) {
        Kisi kisi = kisiMapper.toEntity(kisiDto);
        kisi = kisiRepository.save(kisi);
        auditService.logAction("CREATE_KISI", "Created Kisi with id: " + kisi.getId());
        return kisiMapper.toDto(kisi);
    }

    @Transactional
    @Override
    public KisiDto updateKisi(Long id, KisiDto kisiDto) {
        if (!kisiRepository.existsById(id)) {
            auditService.logAction("UPDATE_KISI", "Kisi not found with id: " + id);
            return null;
        }
        Kisi kisi = kisiMapper.toEntity(kisiDto);
        kisi.setId(id);
        kisi = kisiRepository.save(kisi);
        auditService.logAction("UPDATE_KISI", "Updated Kisi with id: " + kisi.getId());
        return kisiMapper.toDto(kisi);
    }

    @Override
    public void deleteKisi(Long id) {
        Kisi kisi = kisiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kisi not found with id " + id));
        kisi.setDurum(Durum.MANTIKSAL_SILINMIS);
        kisiRepository.save(kisi);
        auditService.logAction("DELETE_KISI", "Deleted Kisi with id: " + id);
    }
}
