package models;

public class Item {
	private String id;
	private String name;
	private String imageFile;
	private int price;
	
	public Item(String id, String name, String imageFile, int price) {
		this.name = name;
		this.imageFile = imageFile;
		this.price = price;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getImageFile() {
		return imageFile;
	}

	public int getPrice() {
		return price;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return ("id - " + this.id + ", name - " + this.name + ", image file - "
				+ this.imageFile + ", price - " + this.price + ".");
	}
	
}
