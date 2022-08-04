package com.grupo.salinas.consumir.service;

import com.grupo.salinas.consumir.model.ResponseBody;
import com.grupo.salinas.consumir.repository.ConsumeServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsumeServicioService {
    @Autowired
    ConsumeServicioRepository cons;
     
    //Mandamos la operacion y el valor que se generó aleatorio
    public ResponseBody getOperacion(String operacion, Object valor) {
        ResponseBody body = new ResponseBody();
        
        //Obtenemos una respuesta del consumo del servicio (response)
        ResponseEntity response= cons.getConsume(operacion, valor);
        body.setResponse(response.getBody());
        body.setStatusCode(response.getStatusCode());
        //validamos el estatus, si es perteneciente a 200 mandamos el siguente mesaje
        if(response.getStatusCode().is2xxSuccessful())
            body.setStatusMessage("Consumo correctamente del servicio");
        //si no, se manda el siguente mensaje
        else
            body.setStatusMessage("No se consumio correctamente del servicio");
        return body;
    }
}
