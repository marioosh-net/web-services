package pl.szkolenie.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	private String street;
	private String house;
	private String zipcode;
	private String city;
	
	public Address() {
	}
	
	public Address(String street, String house, String zipcode, String city) {
		super();
		this.street = street;
		this.house = house;
		this.zipcode = zipcode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", house=" + house + ", zipcode="
				+ zipcode + ", city=" + city + "]";
	}
	
}
