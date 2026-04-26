package com.postreria.server.Commons.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postreria.server.Commons.exception.badRequestException;
import com.postreria.server.Commons.response.*;
import com.postreria.server.Commons.services.ConvertidorService;

import lombok.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/convertidor")
public class ConvertidorController {

    private final ConvertidorService service;

    @GetMapping("/convertir")
    public ResponseEntity<apiResponse<Double>> convertir(@RequestParam String destino,
                                                         @RequestParam double monto) {
        if (destino == null || destino.isBlank()) {
            throw new badRequestException("La moneda de destino es obligatoria");
        }
        if (monto <= 0) {
            throw new badRequestException("El monto debe ser mayor a cero");
        }

        double resultado = service.convertir(destino, monto);
        return ResponseEntity.ok(responseUtil.success(resultado, "Conversion realizada correctamente"));
    }
}
