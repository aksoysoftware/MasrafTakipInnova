package com.innova.masraftakip.service.background;

import com.innova.masraftakip.data.entity.Audit;
import com.innova.masraftakip.data.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void logAction(String aksiyon, String detay) {
        Audit audit = Audit.builder()
                .aksiyon(aksiyon)
                .timestamp(LocalDateTime.now())
                .detay(detay)
                .build();
        auditRepository.save(audit);
    }
}