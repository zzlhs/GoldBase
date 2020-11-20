package com.zzl.stream8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestStream {

	public static void main(String[] args) {
		
		Property p1 = new Property("叫了个", 1000, 500, 2);
	    Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
	    Property p3 = new Property("永和大王", 580, 3000, 1);
	    Property p4 = new Property("肯德基", 6000, 200, 4);
	    List<Property> properties = Arrays.asList(p1, p2, p3, p4);
	    
	    Property pTemp =properties.stream()
//	    		.max(comparator)
	    								.sorted(Comparator.comparingInt(p -> p.getDistance()))
					    				.findFirst()
					    				.get();
	    
	    System.out.println("距离我最近的店铺是:" + pTemp.getName());
	}

}

class Property{
	String name;
	Integer distance;
	Integer sales;
	Integer priceLevel;
	
	public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}
	
	
}