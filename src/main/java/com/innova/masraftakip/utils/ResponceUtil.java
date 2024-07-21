package com.innova.masraftakip.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponceUtil {

    public static <T> ResponseEntity<ApiResponse<T>> wrapOrNoContent(List<T> maybeResponse) {
        if (maybeResponse != null && !maybeResponse.isEmpty()) {
            return ResponseEntity.ok((ApiResponse<T>) new ApiResponse<>(HttpStatus.OK.value(), maybeResponse, null));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public static <T> ResponseEntity<ApiResponse<T>> wrapOrNotFound(T maybeResponse) {
        if (maybeResponse != null) {
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), maybeResponse, null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), null, "Resource not found"));
        }
    }

    public static <T> ResponseEntity<ApiResponse<T>> wrapOk(T response) {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), response, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> wrapCreated(T response) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(HttpStatus.CREATED.value(), response, null));
    }
}
