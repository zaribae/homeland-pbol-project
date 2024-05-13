package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.model.Message;
import com.homeland.homeland.repository.MessageRepository;
import com.homeland.homeland.repository.PropertyRepository;
import com.homeland.homeland.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public void save(MessageRequest request) {
        messageRepository.save(Message.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .property(propertyRepository.findById(request.getPropertyId()).orElseThrow())
                .build());
    }
}
