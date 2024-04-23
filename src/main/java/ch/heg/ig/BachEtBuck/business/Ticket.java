package ch.heg.ig.BachEtBuck.business;

import ch.heg.ig.BachEtBuck.model.BaseEntity;
import ch.heg.ig.BachEtBuck.model.Person;
import ch.heg.ig.BachEtBuck.owner.Pet;
import ch.heg.ig.BachEtBuck.owner.Visit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

	@Column(name = "price")
	@NotBlank
	private String price;

	@Column(name = "date")
	@NotBlank
	private String date;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Ticket{" + "price='" + price + '\'' + ", date='" + date + '\'' + '}';
	}

}
