package pl.szkolenie;

import pl.szkolenie.ws.UserRepositoryImpl;
import pl.szkolenie.ws.UserRepositoryImplService;

public class Consumer {
	public static void main(String[] args) {
		UserRepositoryImplService service = new UserRepositoryImplService();
		UserRepositoryImpl usersRepository = service.getUserRepositoryImplPort();
		
		usersRepository.getAll()
	}
}
