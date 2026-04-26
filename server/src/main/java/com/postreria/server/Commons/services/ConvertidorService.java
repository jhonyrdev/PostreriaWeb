package com.postreria.server.Commons.services;

import org.springframework.stereotype.Service;

import com.postreria.server.Commons.exception.badRequestException;

@Service
public class ConvertidorService {
    public double convertir(String destino, double monto) {
        double tasa;

        switch (destino.toUpperCase()) {
            case "USD": tasa = 3.37; break;
            case "EUR": tasa = 3.93; break;
            default:
                throw new badRequestException("Moneda de destino no soportada: " + destino);
        }

        return monto / tasa;
    }
}
