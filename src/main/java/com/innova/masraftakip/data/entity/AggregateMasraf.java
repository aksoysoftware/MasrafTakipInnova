package com.innova.masraftakip.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AGGREGATE_MASRAF")
public class AggregateMasraf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "KISI_ID", nullable = false)
    private Kisi kisi;

    @Column(name = "PERIOD", nullable = false)
    private String period;

    @Column(name = "TOTAL_MASRAF", nullable = false)
    private Double totalMasraf;

    @Column(name = "AGGREGATED_AT", nullable = false)
    private Timestamp aggregatedAt;
}
