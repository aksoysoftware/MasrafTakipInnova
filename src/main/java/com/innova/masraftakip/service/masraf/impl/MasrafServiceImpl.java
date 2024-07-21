package com.innova.masraftakip.service.masraf.impl;

import com.innova.masraftakip.data.repository.MasrafRepository;
import com.innova.masraftakip.service.masraf.MasrafService;

public class MasrafServiceImpl implements MasrafService {

    private final MasrafRepository masrafRepository;

    public MasrafServiceImpl(MasrafRepository masrafRepository) {
        this.masrafRepository = masrafRepository;
    }
}
