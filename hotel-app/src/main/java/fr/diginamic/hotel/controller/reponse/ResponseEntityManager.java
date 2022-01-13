package fr.diginamic.hotel.controller.reponse;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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
    public <T> ResponseEntity<T> ResponseEntityBuilderValid(T message){
        return ResponseEntity.ok()
                .header(HttpHeaders.CONNECTION, "OK")
                .header(HttpHeaders.CONTENT_DISPOSITION,"Demande valide")
                .body(message);
    }
    public ResponseEntity<String> ResponseEntityBuilderError(String message)  {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
