package com.konrad.testconnectmysql.controller;

import com.konrad.testconnectmysql.repository.MessageRepository;
import com.konrad.testconnectmysql.entitie.Message;
import com.konrad.testconnectmysql.controller.response.MessageResponse;
import com.konrad.testconnectmysql.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping(path = "/message")
    @ResponseBody
    public MessageResponse addNewMessage(
            @RequestParam String title,
            @RequestParam String body) {
        Message message = messageService.addNewMessage(title, body);
        return new MessageResponse(message);
    }

    @GetMapping(path="/message")
    public @ResponseBody Iterable<Message> getAllMessage() { return messageRepository.findAll(); }

}
