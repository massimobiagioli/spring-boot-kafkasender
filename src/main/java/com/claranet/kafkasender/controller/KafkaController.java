package com.claranet.kafkasender.controller;

import com.claranet.kafkasender.message.DummyMessage;
import com.claranet.kafkasender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final MessageSender messageSender;

    @Autowired
    public KafkaController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/sendStr")
    public void send(@RequestBody String msg) {
        messageSender.send(msg);
    }

    @PostMapping("/sendDummy")
    public void send(@RequestBody DummyMessage msg) {
        messageSender.send(msg);
    }
}
