package fr.diginamic.hotel.services;

import fr.diginamic.hotel.entite.Chambre;
import fr.diginamic.hotel.exception.BadRequestException;
import fr.diginamic.hotel.exception.ErrorHotel;
import fr.diginamic.hotel.repository.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChambreService {

    private final ChambreRepository repository;

    public ChambreService(ChambreRepository chambreRepository) {
        repository = chambreRepository;
    }
    public void controlChamberInHotelExist(String hotel,List<Chambre> reserveChambers) throws BadRequestException {
        List<Chambre> chambers = repository.findAllByHotelNom(hotel);
        List<String> code = reserveChambers
                .stream()
                .filter(chambre -> !chambers.contains(chambre))
                .map(Chambre::getCode)
                .collect(Collectors.toList());
        if (code.size() == 0)
            throw new BadRequestException((ErrorHotel.NOT_CHAMBER), code);
    }


}
