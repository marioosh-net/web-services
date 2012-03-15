package pl.szkolenie.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.sun.xml.internal.ws.developer.SchemaValidation;

import pl.szkolenie.model.User;

@HandlerChain(file="server-handler-chain.xml")
@SchemaValidation
@WebService
public class UsersRepositoryImpl implements UsersRepopsitory {

	private long lastId;
	private Map<Long, User> users = new LinkedHashMap<>();

	@Override
	public long addUser(User user) {
		users.put(++lastId, user);
		return lastId;
	}

	@Override
	public User getUser(long id) {
		if (users.containsKey(id)) {
			return users.get(id);
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Collection<User> getAll() {
		return users.values();
	}

}
