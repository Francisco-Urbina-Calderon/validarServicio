package com.grupo.salinas.consumir.controller;

import com.grupo.salinas.consumir.repository.ConsumeServicioRepository;
import com.grupo.salinas.consumir.service.ConsumeServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.grupo.salinas.consumir.model.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/servicio")
public class ConsumeServicioCotroller {
    @Autowired
    ConsumeServicioService consumeServicioService;

    @GetMapping("operacion/{operacion}")
    public ResponseEntity getOperacion(@PathVariable("operacion") String operacion){
        int val = new Random().nextInt(101);
        ResponseBody response = consumeServicioService.getOperacion(operacion,val);
        //Retornamos la respuesta que nos da el servicio
        return new ResponseEntity<>(response.getResponse(),response.getStatusCode());
    }
}
