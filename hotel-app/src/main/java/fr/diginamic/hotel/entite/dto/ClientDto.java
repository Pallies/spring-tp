package fr.diginamic.hotel.entite.dto;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public class ClientDto {

    private String numero;

    @Size(min = 2)
    private String nom;

    @Size(min = 2)
    private String prenoms;
}
