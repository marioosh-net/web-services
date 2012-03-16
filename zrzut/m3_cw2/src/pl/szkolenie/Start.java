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
		
		Address address = new Address("Miła", "2a", "54-323", "Katowice");
		Set<Phone> phones = new LinkedHashSet<>();
		phones.add(new Phone("34-435-533"));
		phones.add(new Phone("34-235-533"));
		phones.add(new Phone("34-635-533"));		
		User user = new User("Jan", "Kowalski", phones, address, "123");		
		
		File file = new File("user.xml");
		marshaller.marshal(user, file);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		user = (User) unmarshaller.unmarshal(file);
		
		marshaller.marshal(user, System.out);
		
	}

}
