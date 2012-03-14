package pl.szkolenie.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import pl.szkolenie.model.User;

@WebService
public class UserRepositoryImpl implements UserRepository {

	private long lastId;
	Map<Long, User> users = new HashMap<Long, User>();
	
	@Override
	public long addUser(User user) {
		users.put(++lastId, user);
		return lastId;
	}

	@Override
	public User getUser(long id) {
		if(users.containsKey(id)) {
			return users.get(id);
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Collection<User> getAll() {
		return users.values();
	}

}
