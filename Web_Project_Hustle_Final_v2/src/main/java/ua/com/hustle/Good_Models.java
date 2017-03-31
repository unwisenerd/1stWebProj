package ua.com.hustle;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	
	//@NamedQuery(name = "findAll", query = "from Good_Models"),
	@NamedQuery(name = "findByModelName", query = "select a from Good_Models a where a.modelName =:param")
	
})


@Entity
@Table(indexes={@Index(columnList = "modelName"),@Index(columnList = "price")})
public class Good_Models {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String modelName;
	
	private int price;
	
	private int version;

	@ManyToOne(fetch=FetchType.LAZY)
	private Goods good;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Good_Type goodType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private GPU_Type gpuType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Memory memoryType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Procc_Type proccType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ram_Type ramType;
	
	@ManyToMany
	@JoinTable(name="user_models",
		joinColumns=@JoinColumn(name="id_goodModel"),
		inverseJoinColumns=@JoinColumn(name="id_user"))
	private List<User> users;
	
	
	public Good_Models() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Good_Models(String modelName) {
		super();
		this.modelName = modelName;
	}



	public Good_Models(String modelName, int price) {
	super();
	this.modelName = modelName;
	this.price = price;
}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getModelName() {
		return modelName;
	}



	public void setModelName(String modelName) {
		this.modelName = modelName;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public Goods getGood() {
		return good;
	}



	public void setGood(Goods good) {
		this.good = good;
	}



	public Good_Type getGoodType() {
		return goodType;
	}



	public void setGoodType(Good_Type goodType) {
		this.goodType = goodType;
	}



	public GPU_Type getGpuType() {
		return gpuType;
	}



	public void setGpuType(GPU_Type gpuType) {
		this.gpuType = gpuType;
	}
	public int getVersion() {
		return version;
	}
	
	
	
	public void setVersion(int version) {
		this.version = version;
	}



	public Memory getMemoryType() {
		return memoryType;
	}



	public void setMemoryType(Memory memoryType) {
		this.memoryType = memoryType;
	}



	public Procc_Type getProccType() {
		return proccType;
	}



	public void setProccType(Procc_Type proccType) {
		this.proccType = proccType;
	}



	public Ram_Type getRamType() {
		return ramType;
	}



	public void setRamType(Ram_Type ramType) {
		this.ramType = ramType;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((good == null) ? 0 : good.hashCode());
		result = prime * result
				+ ((goodType == null) ? 0 : goodType.hashCode());
		result = prime * result + ((gpuType == null) ? 0 : gpuType.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((memoryType == null) ? 0 : memoryType.hashCode());
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + price;
		result = prime * result
				+ ((proccType == null) ? 0 : proccType.hashCode());
		result = prime * result + ((ramType == null) ? 0 : ramType.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Good_Models other = (Good_Models) obj;
		if (good == null) {
			if (other.good != null)
				return false;
		} else if (!good.equals(other.good))
			return false;
		if (goodType == null) {
			if (other.goodType != null)
				return false;
		} else if (!goodType.equals(other.goodType))
			return false;
		if (gpuType == null) {
			if (other.gpuType != null)
				return false;
		} else if (!gpuType.equals(other.gpuType))
			return false;
		if (id != other.id)
			return false;
		if (memoryType == null) {
			if (other.memoryType != null)
				return false;
		} else if (!memoryType.equals(other.memoryType))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (price != other.price)
			return false;
		if (proccType == null) {
			if (other.proccType != null)
				return false;
		} else if (!proccType.equals(other.proccType))
			return false;
		if (ramType == null) {
			if (other.ramType != null)
				return false;
		} else if (!ramType.equals(other.ramType))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Good_Models [id=" + id + ", modelName=" + modelName
				+ ", price=" + price + ", good=" + good + ", goodType="
				+ goodType + ", gpuType=" + gpuType + ", memoryType="
				+ memoryType + ", proccType=" + proccType + ", ramType="
				+ ramType + "]";
	}






	
	
}
