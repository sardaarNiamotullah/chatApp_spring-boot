package com.sardaar.chatapp.service;

import com.sardaar.chatapp.entity.ChatMessage;
import com.sardaar.chatapp.entity.User;
import com.sardaar.chatapp.repository.ChatMessageRepository;
import com.sardaar.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ChatMessage> getMessagesBetweenUsers(String sender, String recipient) {
        return chatMessageRepository.findBySenderUsernameOrRecipientUsername(sender, recipient);
    }

    public ChatMessage createMessage(ChatMessage message) {
        // Ensure sender is persisted
        User sender = userRepository.findByUsername(message.getSender().getUsername())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        // Ensure recipient is persisted
        User recipient = userRepository.findByUsername(message.getRecipient().getUsername())
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        message.setSender(sender);
        message.setRecipient(recipient);

        return chatMessageRepository.save(message);
    }
}
