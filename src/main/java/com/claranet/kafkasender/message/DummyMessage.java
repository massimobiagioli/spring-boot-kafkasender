package com.claranet.kafkasender.message;

public class DummyMessage {
    private String cod;
    private String description;

    public DummyMessage() {
    }

    public DummyMessage(String cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
