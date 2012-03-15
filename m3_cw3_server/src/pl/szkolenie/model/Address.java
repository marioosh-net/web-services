package pl.szkolenie.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	
	@XmlAttribute
	private String street;
	
	@XmlAttribute
	private String house;
	
	@XmlAttribute
	private String zipcode;
	
	@XmlAttribute
	private String city;

	public Address() {
	}

	public Address(String street, String house, String zipcode, String city) {
		this.street = street;
		this.house = house;
		this.zipcode = zipcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", house=" + house + ", zipcode="
				+ zipcode + ", city=" + city + "]";
	}

}
