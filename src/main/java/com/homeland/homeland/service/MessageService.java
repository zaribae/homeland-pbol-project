package com.homeland.homeland.service;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.model.Message;

public interface MessageService {

    void save(MessageRequest request);
    Iterable<Message> findAll();
}
