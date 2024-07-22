package com.innova.masraftakip.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="ROL")
public class Rol extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String isim;
}
