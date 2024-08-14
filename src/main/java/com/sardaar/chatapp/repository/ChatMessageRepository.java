package com.sardaar.chatapp.repository;

import com.sardaar.chatapp.entity.ChatMessage;
import com.sardaar.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderUsernameOrRecipientUsername(String senderUsername, String recipientUsername);
}

