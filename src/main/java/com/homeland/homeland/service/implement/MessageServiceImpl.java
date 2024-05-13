package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.model.Message;
import com.homeland.homeland.repository.MessageRepository;
import com.homeland.homeland.service.MessageService;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final PropertyService propertyService;

    @Override
    public void save(MessageRequest request) {
        messageRepository.save(Message.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .property(propertyService.findById(request.getPropertyId()))
                .build());
    }

    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }
}
