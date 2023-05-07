package com.app_web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.math.BigDecimal;

public class AppService {
	private ArrayList<BigDecimal> nums;
	private String name;
	private int quantity;
	private BigDecimal add;
	private String pathFile;
	
	public AppService(String pathFile) {
		this.pathFile = pathFile;
		this.nums = new ArrayList<BigDecimal>();
		this.getListNums();	
		this.name = "";
		this.quantity = 0;
		this.add = new BigDecimal("0");
	}
	
	public String getName() {
		this.name = "202010723 Pilar Andrea Corredor Corredor";
		return name;
	}
	
	private ArrayList<BigDecimal> getListNums(){
		Path path = Paths.get(pathFile);
		String content = "";
		try {
			content = Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		double prueba = 0;
		String[] auxContent = content.split("\\R");
		for (int i = 0; i < auxContent.length; i++) {
			try{
				prueba=Double.parseDouble(auxContent[i]);
	    	}catch(NumberFormatException ex){
	        	System.out.println("No es un número");
	    	}
			nums.add(new BigDecimal(auxContent[i]));
		}	
		return nums;
	}
	
	public BigDecimal getAdd() {
		Path path = Paths.get(pathFile);
		String content = "";
		try {
			content = Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] auxContent = content.split("\\R");
		for (int i = 0; i < auxContent.length; i++) {
			add = add.add(new BigDecimal(auxContent[i]));
		}
		return add;
	}
	
	public int getQuantity() {
		quantity = nums.size();
		return quantity;
	}
}
