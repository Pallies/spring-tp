package fr.diginamic.hotel.exception;

public enum ErrorHotel {
    NOT_CLIENT("numéro non trouvé"),
    NOT_CHAMBER("la chambre %s n'existe pas");

    ErrorHotel(String s) {
    }


}
