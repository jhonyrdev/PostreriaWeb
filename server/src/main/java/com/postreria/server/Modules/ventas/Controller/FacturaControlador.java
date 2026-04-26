package com.postreria.server.Modules.ventas.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postreria.server.Commons.response.*;
import com.postreria.server.Modules.ventas.Dto.BuscarFacturaDTO;
import com.postreria.server.Modules.ventas.Service.FacturaServicio;

import lombok.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaControlador {

    private final FacturaServicio buscarfacserv;

    @GetMapping("/facturas/{nfac}")
    public ResponseEntity<apiResponse<List<BuscarFacturaDTO>>> buscarFac(@PathVariable String nfac){
        List<BuscarFacturaDTO> facturas = buscarfacserv.buscarFac(nfac);
        return ResponseEntity.ok(responseUtil.success(facturas, "Facturas obtenidas correctamente"));
    }
}
