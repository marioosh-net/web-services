package pl.szkolenie.service;

import java.util.Collection;

import javax.jws.WebService;

import pl.szkolenie.model.User;

@WebService
public interface UserRepository {
	long addUser(User user);
	User getUser(long id);
	Collection<User> getAll();
}
