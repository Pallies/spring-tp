package dev.paie.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Periode extends BaseEntity {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


}
