package fr.diginamic.hotel.controller.reponse;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Response entity manager.
 */
public abstract class ResponseEntityManager {

    /**
     * Response entity builder response entity.
     *
     * @param message the message
     * @return the response entity
     */
    public <T> ResponseEntity<T> ResponseEntityBuilderValid(T message) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONNECTION, "OK")
                .header(HttpHeaders.CONTENT_DISPOSITION, "Demande valide")
                .body(message);
    }

    public ResponseEntity<?> ResponseEntityBuilderError(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
}
