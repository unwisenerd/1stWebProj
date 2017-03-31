package ua.com.hustle;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(indexes={@Index(columnList = "madeCountry")})
public class Goods {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String madeCountry; 
	
	@OneToMany(mappedBy="good")
	private List<Good_Models> goodModels;
	 
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(String madeCountry) {
		super();
		this.madeCountry = madeCountry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMadeCountry() {
		return madeCountry;
	}

	public void setMadeCountry(String madeCountry) {
		this.madeCountry = madeCountry;
	}

	public List<Good_Models> getGoodModels() {
		return goodModels;
	}

	public void setGoodModels(List<Good_Models> goodModels) {
		this.goodModels = goodModels;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", madeCountry=" + madeCountry + "]";
	}
	
	
	






	

	

}
