package com.yedam.quiz;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // prefix for the client to send messages to the server
        config.setApplicationDestinationPrefixes("/app");
        // prefix for the client to receive broadcasted messages from the server
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // defines the url of the socket so the client can connect to it
        registry.addEndpoint("/sock")
        .setAllowedOriginPatterns("*")
       // .setAllowedOrigins("*")
        .withSockJS();
    }
}