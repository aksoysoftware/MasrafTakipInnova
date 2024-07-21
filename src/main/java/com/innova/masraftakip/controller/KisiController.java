package com.innova.masraftakip.controller;

import com.innova.masraftakip.dto.KisiDto;
import com.innova.masraftakip.service.kisi.KisiService;
import com.innova.masraftakip.utils.ApiResponse;
import com.innova.masraftakip.utils.ResponceUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/kisi")
public class KisiController {

    private final KisiService kisiService;

    public KisiController(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<KisiDto>>> getAllKisiler() {
        List<KisiDto> kisiler = kisiService.getAllKisiler();
        return ResponceUtil.wrapOrNoContent(Collections.singletonList(kisiler));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KisiDto>> getKisiById(@PathVariable Long id) {
        KisiDto kisi = kisiService.getKisiById(id);
        return ResponceUtil.wrapOrNotFound(kisi);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<KisiDto>> createKisi(@RequestBody KisiDto kisiDTO) {
        KisiDto result = kisiService.createKisi(kisiDTO);
        return ResponceUtil.wrapCreated(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KisiDto>> updateKisi(@PathVariable Long id, @RequestBody KisiDto kisiDTO) {
        KisiDto result = kisiService.updateKisi(id, kisiDTO);
        return ResponceUtil.wrapOk(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKisi(@PathVariable Long id) {
        kisiService.deleteKisi(id);
        return ResponseEntity.ok(new ApiResponse<>(200, null, null));
    }
}
