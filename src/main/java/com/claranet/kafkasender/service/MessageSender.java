package com.claranet.kafkasender.service;

import com.claranet.kafkasender.message.DummyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    private final KafkaTemplate<String, String> kafkaTemplateStr;
    private final KafkaTemplate<String, DummyMessage> kafkaTemplateDummyMessage;

    @Autowired
    public MessageSender(
            KafkaTemplate<String, String> kafkaTemplateStr,
            KafkaTemplate<String, DummyMessage> kafkaTemplateDummyMessage
    ) {
        this.kafkaTemplateStr = kafkaTemplateStr;
        this.kafkaTemplateDummyMessage = kafkaTemplateDummyMessage;
    }

    public void send(String msg) {
        kafkaTemplateStr.send("dummy", msg);
    }

    public void send(DummyMessage msg) {
        kafkaTemplateDummyMessage.send("dummy", "kdummy", msg);
    }
}
