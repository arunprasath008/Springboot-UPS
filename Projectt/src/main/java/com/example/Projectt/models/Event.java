package com.example.Projectt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

    public Event(long id, String name, String location, double price, String description, String detailedAddress,
			String images, String category, String timing, int entryfee) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
		this.description = description;
		this.detailedAddress = detailedAddress;
		this.images = images;
		this.category = category;
		Timing = timing;
		this.entryfee = entryfee;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String location;
    private double price;
    private String description;
    private String detailedAddress;
    private String images;
    private String category;
    private String Timing;
    private int entryfee;
    public Event() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTiming() {
		return Timing;
	}
	public void setTiming(String timing) {
		Timing = timing;
	}
	public int getEntryfee() {
		return entryfee;
	}
	public void setEntryfee(int entryfee) {
		this.entryfee = entryfee;
	}
}
