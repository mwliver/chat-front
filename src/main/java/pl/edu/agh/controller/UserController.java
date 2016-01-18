package pl.edu.agh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.edu.agh.model.User;
import pl.edu.agh.rest.UrlsList;
import pl.edu.agh.rest.UserService;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(User.class, "user",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : getUserById(Integer.parseInt((String) text)));
					}
				});
	}

	@RequestMapping("/list")
	public String hello(Model model) {
		List<User> users = userService.getAll();

		model.addAttribute("users", users);
		return "listUsers";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String viewAddUser(Model model) {
		System.out.println("w get");
		User user = new User();
		model.addAttribute("userForm", user);
		System.out.println("w get");

		return "addUser";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("userForm") User user,
			Model model) {
		try {
			userService.postUser(user, UrlsList.GET_SAVE_USER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Dodano użytkownika");
		model.addAttribute("userForm", new User());

		return "addUser";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String saveUser(@RequestParam("id") long id, Model model) {

		List<User> users = userService.getAll();

		User userToDelete = null;
		for (User user : users) {
			if (user.getId() == id) {
				userToDelete = user;
				break;
			}
		}

		try {
			userService.postUser(userToDelete, UrlsList.GET_REMOVE_USER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Usunięto użytkownika");
		users = userService.getAll();
		model.addAttribute("users", users);

		return "listUsers";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateUserView(@RequestParam("id") long id, Model model) {

		List<User> users = userService.getAll();
		for (User pat : users)
			System.out.println(pat);
		System.out.println("After getting from service");
		System.out.println(users);
		User userToDelete = null;
		for (User user : users) {
			System.out.println(user);
			if (user.getId() == id) {
				userToDelete = user;
				break;
			}
		}

		model.addAttribute("user", userToDelete);

		return "editUser";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,
			Model model) {
		try {
			userService.postUser(user, UrlsList.GET_SAVE_USER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Zaktualizowano użytkownika");
		model.addAttribute("user", user);

		return "editUser";

	}
	
	public User getUserById(long id) {
		List<User> userList = userService.getAll();
		User endUser = null;
		for (User user : userList) {
			if (user.getId() == id) {
				endUser = user;
				break;
			}
		}
		
		return endUser;
		
	}

}
