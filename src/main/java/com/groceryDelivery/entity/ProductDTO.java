package com.groceryDelivery.entity;

public class ProductDTO {
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", pictureUrl=" + pictureUrl + "]";
	}
	private Long id;
    private String name;
    private String description;
    private Double price;
    private String pictureUrl;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(Long id, String name, String description, Double price, String pictureUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.pictureUrl = pictureUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	

}
