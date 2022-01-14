package fr.diginamic.hotel.exception;

import java.util.ArrayList;
import java.util.List;

public class BadRequestException extends Exception {

    public BadRequestException(ErrorHotel messageError, List<String> parameters) {
        super(format(messageError, parameters) );
    }

    private static String format(ErrorHotel messageError, List<String> parameters){
        List<String> listError=new ArrayList<>();
        for(String param : parameters){
           listError.add(String.format(messageError.toString(), param));
        }
        return listError.toString();
    }
}

