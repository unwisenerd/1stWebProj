package ua.com.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class ModelFilter {
	
	private String search = "";
	
	private String min = "";
	
	private String max = "";
	
	private int minValue;
	
	private int maxValue;
		
	private List<Integer> goodTypesId = new ArrayList<>();
	
	private List<Integer> goodsId = new ArrayList<>();
	
	private List<Integer> gpuTypesId = new ArrayList<>();
	
	private List<Integer> memoriesId = new ArrayList<>();
	
	private List<Integer> proccTypesId = new ArrayList<>();
	
	private List<Integer> ramTypesId = new ArrayList<>();

	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public List<Integer> getGoodTypesId() {
		return goodTypesId;
	}

	public void setGoodTypesId(List<Integer> goodTypesId) {
		this.goodTypesId = goodTypesId;
	}

	public List<Integer> getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(List<Integer> goodsId) {
		this.goodsId = goodsId;
	}

	public List<Integer> getGpuTypesId() {
		return gpuTypesId;
	}

	public void setGpuTypesId(List<Integer> gpuTypesId) {
		this.gpuTypesId = gpuTypesId;
	}

	public List<Integer> getMemoriesId() {
		return memoriesId;
	}

	public void setMemoriesId(List<Integer> memoriesId) {
		this.memoriesId = memoriesId;
	}

	public List<Integer> getProccTypesId() {
		return proccTypesId;
	}

	public void setProccTypesId(List<Integer> proccTypesId) {
		this.proccTypesId = proccTypesId;
	}

	public List<Integer> getRamTypesId() {
		return ramTypesId;
	}

	public void setRamTypesId(List<Integer> ramTypesId) {
		this.ramTypesId = ramTypesId;
	}
	


}
