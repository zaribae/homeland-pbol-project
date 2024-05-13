package com.homeland.homeland.repository;

import com.homeland.homeland.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
