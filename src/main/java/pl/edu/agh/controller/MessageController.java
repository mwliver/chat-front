package pl.edu.agh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.edu.agh.model.Message;
import pl.edu.agh.rest.MessageService;
import pl.edu.agh.rest.UrlsList;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Message.class, "message",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : null);
					}
				});
	}

	@RequestMapping("/list")
	public String hello(Model model) {
		List<Message> messages = messageService.getAll();

		Message message = new Message();

		model.addAttribute("messageForm", message);

		model.addAttribute("messages", messages);
		return "listMessages";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String viewAddCarer(Model model) {
		Message message = new Message();

		model.addAttribute("messageForm", message);

		return "listMessages";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCarer(@ModelAttribute("messageForm") Message msg,
			Model model) {
		msg.setCreateDate(new Date());
		try {
			messageService.postMessage(msg, UrlsList.GET_SAVE_MESSAGE_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Message> messages = messageService.getAll();
		model.addAttribute("messages", messages);

		Message message = new Message();
		model.addAttribute("messageForm", message);

		return "listMessages";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String removeCarer(@RequestParam("id") long id, Model model) {

		List<Message> messages = messageService.getAll();

		Message messageToDelete = null;
		for (Message message : messages) {
			if (message.getId() == id) {
				messageToDelete = message;
				break;
			}
		}

		try {
			messageService
					.postMessage(messageToDelete, UrlsList.GET_REMOVE_MESSAGE_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		messages = messageService.getAll();
		model.addAttribute("messages", messages);

		return "listMessages";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateCarerView(@RequestParam("id") long id, Model model) {

		List<Message> messages = messageService.getAll();
		Message messageToUpdate = null;

		for (Message message : messages) {
			if (message.getId() == id) {
				messageToUpdate = message;
				break;
			}
		}

		model.addAttribute("message", messageToUpdate);

		return "editMessage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCarer(@ModelAttribute("message") Message message, Model model) {
//		message.setLastModification(new Date());
//		message.setUserRole("ROLE_CARER");
		try {
			messageService.postMessage(message, UrlsList.GET_SAVE_MESSAGE_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

//		model.addAttribute("info", "Zmieniono dane opiekuna");
		model.addAttribute("message", message);

		return "editMessage";
	}

}
