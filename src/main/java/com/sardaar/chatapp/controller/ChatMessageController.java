package com.sardaar.chatapp.controller;

import com.sardaar.chatapp.entity.ChatMessage;
import com.sardaar.chatapp.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getMessagesBetweenUsers(
            @RequestParam String sender, @RequestParam String recipient) {
        List<ChatMessage> messages = chatMessageService.getMessagesBetweenUsers(sender, recipient);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatMessage> createMessage(@RequestBody ChatMessage message) {
        ChatMessage createdMessage = chatMessageService.createMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }
}
