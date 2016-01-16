package pl.edu.agh.rest;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.model.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MessageService {

    public List<Message> getAll() {

        List<Message> messages = new ArrayList<Message>();

        RestTemplate rt = new RestTemplate();
        Message[] messagesArray = rt.getForObject(UrlsList.GET_BASE_URL
                + UrlsList.GET_MESSAGE_URL, new Message[0].getClass());
        messages = Arrays.asList(messagesArray);

        return messages;
    }

    public void postMessage(Message message, String shortUrl) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(UrlsList.GET_BASE_URL + shortUrl, message,
                Message.class);
    }
}
