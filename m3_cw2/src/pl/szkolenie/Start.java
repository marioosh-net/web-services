package pl.szkolenie;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pl.szkolenie.model.Address;
import pl.szkolenie.model.Phone;
import pl.szkolenie.model.User;

public class Start {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(User.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Address address = new Address("Jasna", "3d", "43-222", "Kraków");
		Set<Phone> phones = new LinkedHashSet<Phone>();
		phones.add(new Phone("122-232-222"));
		phones.add(new Phone("333-2321-22"));
		
		User user = new User("Jan", "Kowalski", phones, address, "password");
		
		marshaller.marshal(user, System.out);
		
		File file = new File("user.xml");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		user = (User) unmarshaller.unmarshal(file);
		
		marshaller.marshal(user, System.out);

	}
}
