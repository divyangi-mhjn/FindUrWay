package com.hp.major.FindUrWay;

import java.util.Date;

public class Chat {
    private String chatId;

    private String messageText;
    private String messageUser;
    private String messageTime;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Chat(String chatId, String messageText, String messageUser,String messageTime) {
        this.chatId = chatId;

        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageTime = messageTime;


        // Initialize to current time


    }

    public Chat(){

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
