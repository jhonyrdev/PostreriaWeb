package com.postreria.server.Modules.ventas.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postreria.server.Modules.catalogo.Dto.ProductoDTO;
import com.postreria.server.Modules.clientes.Entity.Clientes;
import com.postreria.server.Modules.clientes.Repository.UsuariosRepository;
import com.postreria.server.Modules.ventas.Entity.*;
import com.postreria.server.Modules.ventas.Repository.*;
import com.postreria.server.Modules.ventas.Service.MetodoPagoService;

import jakarta.transaction.Transactional;
import lombok.*;

@RequiredArgsConstructor
@Controller
public class CarritoControlador {

    private final FacturaRepository facturaRepository;
    private final DetalleFacturaRepository detalleFacturaRepository;
    private final MetodoPagoService metodoPagoService;
    private final UsuariosRepository usuariosRepository;

    @PostMapping("/realizarCompra")
    @Transactional
    public String realizarCompra(@RequestParam String nombres,
                             @RequestParam String apellidos,
                             @RequestParam String correo,
                             @RequestParam String telefono,
                             @RequestParam String direccion,
                             @RequestParam String ciudad,
                             @RequestParam String codigoPostal,
                             @RequestParam String pago,
                             @RequestParam String carritoJson,
                             RedirectAttributes redirectAttrs) throws Exception {

    int idPago = metodoPagoService.obtenerIdPorTipo(pago);

    // Buscar cliente por correo
    Clientes cliente = usuariosRepository.findByCorreo(correo);
    if (cliente == null) {
        redirectAttrs.addFlashAttribute("error", "El correo no está registrado en clientes.");
        return "redirect:/pedidos";
    }

    // Crear factura con ID_CLIENTE
    Factura factura = new Factura();
    factura.setIdCliente(cliente.getId());
    factura.setIdPago(idPago);
    factura.setFecha(LocalDate.now());
    factura = facturaRepository.save(factura);

    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Contenido de carritoJson: " + carritoJson);
    List<ProductoDTO> productos = mapper.readValue(carritoJson, new TypeReference<List<ProductoDTO>>() {});
    for (ProductoDTO p : productos) {
    try {
        System.out.println("Insertando detalle: ID=" + p.getId() +
                           ", Cant=" + p.getCantidad() +
                           ", Precio=" + p.getPrecio());

        DetalleFactura detalle = new DetalleFactura();
        detalle.setNFac(factura.getNFac());
        detalle.setIdProducto(p.getId());
        detalle.setCantidad(p.getCantidad());
        detalle.setPrecioUnitario(p.getPrecio());
        detalleFacturaRepository.save(detalle);

    } catch (Exception e) {
        e.printStackTrace(); 
    }
}

    redirectAttrs.addFlashAttribute("mensaje", "Compra realizada con éxito :D");
        return "redirect:/pedidos";
    }

}