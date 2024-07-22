package com.innova.masraftakip.service.background;

import com.innova.masraftakip.config.data.entity.AggregateMasraf;
import com.innova.masraftakip.config.data.entity.Kisi;
import com.innova.masraftakip.config.data.repository.AggregateMasrafRepository;
import com.innova.masraftakip.config.data.repository.KisiRepository;
import com.innova.masraftakip.config.data.repository.MasrafRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AggregationService {

    private final MasrafRepository masrafRepository;
    private final KisiRepository kisiRepository;
    private final AggregateMasrafRepository aggregateMasrafRepository;

    public AggregationService(MasrafRepository masrafRepository, KisiRepository kisiRepository, AggregateMasrafRepository aggregateMasrafRepository) {
        this.masrafRepository = masrafRepository;
        this.kisiRepository = kisiRepository;
        this.aggregateMasrafRepository = aggregateMasrafRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Günlük
    public void aggregateGunlukMasraf() {
        aggregateMasraf("günlük");
    }

    @Scheduled(cron = "0 0 0 * * MON") // Haftalık
    public void aggregateHaftalikMasraf() {
        aggregateMasraf("haftalik");
    }

    @Scheduled(cron = "0 0 0 1 * ?") // Aylık
    public void aggregateAylikMasraf() {
        aggregateMasraf("aylik");
    }

    private void aggregateMasraf(String periyot) {
        List<Kisi> kisiler = kisiRepository.findAll();
        for (Kisi kisi : kisiler) {
            Double totalMasraf = masrafRepository.findTotalMasrafByKisiId(kisi.getId());
            AggregateMasraf aggregateMasraf = AggregateMasraf.builder()
                    .kisi(kisi)
                    .period(periyot)
                    .totalMasraf(totalMasraf)
                    .aggregatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();
            aggregateMasrafRepository.save(aggregateMasraf);
        }
    }
}
