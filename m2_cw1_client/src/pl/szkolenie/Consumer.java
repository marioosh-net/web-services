package pl.szkolenie;

import pl.szkolenie.ws.User;
import pl.szkolenie.ws.UserRepositoryImpl;
import pl.szkolenie.ws.UserRepositoryImplService;

public class Consumer {
	public static void main(String[] args) {
		UserRepositoryImplService service = new UserRepositoryImplService();
		UserRepositoryImpl usersRepository = service.getUserRepositoryImplPort();
		
		long id1 = usersRepository.addUser(new User("Jan", "Kowalski"));
		long id2 = usersRepository.addUser(new User("Adam", "Nowak"));
		
		System.out.println("user1: "+usersRepository.getUser(id1));
		System.out.println("user2: "+usersRepository.getUser(id2));
		
		System.out.println("users: "+usersRepository.getAll());
		
		usersRepository.getUser(0);
	}
}
