package pl.szkolenie;

import pl.szkolenie.ws.User;
import pl.szkolenie.ws.UsersRepositoryImpl;
import pl.szkolenie.ws.UsersRepositoryImplService;

public class Consumer {

	public static void main(String[] args) {
		UsersRepositoryImplService service = new UsersRepositoryImplService();
		UsersRepositoryImpl usersRepository = service.getUsersRepositoryImplPort();
		
		long id1 = usersRepository.addUser(new User("Jan", "Kowalski"));
		long id2 = usersRepository.addUser(new User("Marek", "Nowak"));
		
		System.out.println("User1: " + usersRepository.getUser(id1));
		System.out.println("User2: " + usersRepository.getUser(id2));

		System.out.println("Users: " + usersRepository.getAll());
		
		usersRepository.getUser(0);
	}

}
