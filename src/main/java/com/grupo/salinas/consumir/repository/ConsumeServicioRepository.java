package com.grupo.salinas.consumir.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ConsumeServicioRepository {
    public ResponseEntity getConsume(String operation, Object value){
    	
    	//con RestTemplate le decimos que haga una peticion get hacia la entidad : 
    	//http://localhost:8090/exam/operacion/"+operation+"/"+value.toString(),String.class, (Object) null).getBody()
        //y de ahí se forma el url.
    	RestTemplate rest = new RestTemplate();
        String resp = rest.getForEntity("http://localhost:8090/exam/operacion/"+operation+"/"+value.toString(),String.class, (Object) null).getBody();
        return ResponseEntity.ok(resp);
    }
}
