package pl.edu.agh.rest;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserService {

	public List<User> getAll() {

		List<User> users = new ArrayList<User>();

		RestTemplate rt = new RestTemplate();
		User[] userArray = rt.getForObject(UrlsList.GET_BASE_URL
				+ UrlsList.GET_USERS_URL, new User[0].getClass());
		users = Arrays.asList(userArray);

		return users;
	}

	public User postUser(User user, String shortUrl)
			throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		User result = restTemplate.postForObject(UrlsList.GET_BASE_URL
				+ shortUrl, user, User.class);
		System.out.println(result);
		return result;
	}
}
