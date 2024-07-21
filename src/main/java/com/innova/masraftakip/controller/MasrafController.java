package com.innova.masraftakip.controller;

import com.innova.masraftakip.dto.KisiDto;
import com.innova.masraftakip.dto.MasrafDto;
import com.innova.masraftakip.service.masraf.MasrafService;
import com.innova.masraftakip.utils.ApiResponse;
import com.innova.masraftakip.utils.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/masraf")
public class MasrafController {

    private final MasrafService masrafService;

    @Autowired
    public MasrafController(MasrafService masrafService) {
        this.masrafService = masrafService;
    }


    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<MasrafDto>>> getAllMasraflar() {
        List<MasrafDto> masraflar = masrafService.getAllMasraflar();
        return ResponceUtil.wrapOrNoContent(Collections.singletonList(masraflar));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MasrafDto>> createMasraf(@RequestBody MasrafDto MasrafDto) {
        MasrafDto result = masrafService.createMasraf(MasrafDto);
        return ResponceUtil.wrapCreated(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MasrafDto>> updateMasraf(@PathVariable Long id, @RequestBody MasrafDto masrafDto) {
        MasrafDto result = masrafService.updateMasraf(id, masrafDto);
        return ResponceUtil.wrapOk(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MasrafDto>> getMasrafById(@PathVariable Long id) {
        MasrafDto masrafDto = masrafService.getMasrafById(id);
        return ResponceUtil.wrapOrNotFound(masrafDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKisi(@PathVariable Long id) {
        masrafService.deleteMasraf(id);
        return ResponseEntity.ok(new ApiResponse<>(200, null, null));
    }

    @GetMapping("/toplam/{kisiId}")
    public ResponseEntity<ApiResponse<Double>> getTotalMasrafByKisiId(@PathVariable Long kisiId) {
        Double totalMasraf = masrafService.getTotalMasrafByKisiId(kisiId);
        return ResponseEntity.ok(new ApiResponse<>(200, totalMasraf, null));
    }
}
