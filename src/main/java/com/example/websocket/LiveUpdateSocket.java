package com.example.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/live-updates")
@ApplicationScoped
public class LiveUpdateSocket {

    private Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    private ObjectMapper mapper = new ObjectMapper();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        sendMessage(session, "WebSocket verbunden");
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        sendMessage(session, "Nachricht empfangen: " + message);
    }

    // Broadcast für beliebige DTOs
    public void broadcast(Object dto) {
        try {
            String jsonMessage = mapper.writeValueAsString(dto);
            sessions.forEach(session -> sendMessage(session, jsonMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(Session session, String message) {
        session.getAsyncRemote().sendText(message);
    }
}