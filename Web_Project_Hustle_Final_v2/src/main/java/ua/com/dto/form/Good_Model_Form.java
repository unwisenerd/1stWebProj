package ua.com.dto.form;



import org.springframework.web.multipart.MultipartFile;

import ua.com.hustle.GPU_Type;
import ua.com.hustle.Good_Type;
import ua.com.hustle.Goods;
import ua.com.hustle.Memory;
import ua.com.hustle.Procc_Type;
import ua.com.hustle.Ram_Type;

public class Good_Model_Form {
	
	private int id;
	
	private int version;
	
	private MultipartFile file;
	
	private String modelName;
	
	private String price;
	
	private Goods good;
	
	private Good_Type goodType;
	
	private GPU_Type gpuType;
	
	private Memory memoryType;
	
	private Procc_Type proccType;
	
	private Ram_Type ramType;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	
	
}
