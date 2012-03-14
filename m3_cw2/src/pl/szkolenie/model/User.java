package pl.szkolenie.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.szkolenie.model.adapter.PhoneAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@XmlAttribute
	private String firstName;

	@XmlAttribute
	private String lastName;
	
	@XmlJavaTypeAdapter(PhoneAdapter.class)
	@XmlElementWrapper(name="phones")
	@XmlElement(name="phone")
	private Set<Phone> phones = new LinkedHashSet<Phone>();
	
	private Address address;
	
	@XmlTransient
	private String password;

	public User(String firstName, String lastName, Set<Phone> phones,
			Address address, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
		this.address = address;
		this.password = password;
	}
	
	public User() {
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", phones=" + phones + ", address=" + address + ", password="
				+ password + "]";
	}
	
}
