package com.innova.masraftakip.service;
/*
import com.innova.masraftakip.data.entity.Kisi;
import com.innova.masraftakip.data.repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class KullaniciDetaylariServisi implements UserDetailsService {


    private final KisiRepository kisiRepository;

    public KullaniciDetaylariServisi(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String kullaniciAdi) throws UsernameNotFoundException {
        Kisi kisi = (Kisi) kisiRepository.findByKullaniciAdi(kullaniciAdi)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + kullaniciAdi));

        return new org.springframework.security.core.userdetails.User(
                kisi.getKullaniciAdi(),
                kisi.getSifre(),
                kisi.getRoller().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getIsim()))
                        .collect(Collectors.toList())
        );
    }
}

 */