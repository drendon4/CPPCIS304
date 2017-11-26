package javazon;

public class Product {
	private String sku;
	private String type;
	private String description;
	private double price;
	
	public Product(String aSku, String aType, String aDesc, double aPrice){
		//TODO
		//COPY VARIABLES TO LOCAL CLASS VARIABLES
                sku = aSku;
                type = aType;
                description = aDesc;
                price = aPrice;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
