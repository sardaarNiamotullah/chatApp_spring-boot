package com.sardaar.chatapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    public enum MessageStatus { SENT, RECEIVED, SEEN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_username", referencedColumnName = "username")
    private User sender;

    @ManyToOne
    @JoinColumn(name ="recipient_username", referencedColumnName = "username")
    private User recipient;

    private String content;

    private MessageStatus status;

    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate() { timestamp = LocalDateTime.now();}
}