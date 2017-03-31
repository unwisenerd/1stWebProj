package ua.com.hustle;

import java.util.List;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(indexes={@Index(columnList = "type")})
public class Good_Type {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int version;
	
	@Transient
	private MultipartFile file;
	
	private String type;
	
	@OneToMany(mappedBy="goodType")
	private List<Good_Models> goodModels;

	
	public Good_Type() {
		// TODO Auto-generated constructor stub
	}


	public Good_Type(String type) {
		super();
		this.type = type;
	}
	
	


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
		result = prime * result
				+ ((goodModels == null) ? 0 : goodModels.hashCode());
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Good_Type other = (Good_Type) obj;
		if (goodModels == null) {
			if (other.goodModels != null)
				return false;
		} else if (!goodModels.equals(other.goodModels))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Good_Type [id=" + id + ", type=" + type + "]";
	}
	
	

	
	
	
}
