package com.eliza.elizachat.controller;

import com.eliza.elizachat.model.Question;
import com.eliza.elizachat.model.Response;
import com.eliza.elizachat.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ElizaResponse {
    private final ChatService chatService;

    public ElizaResponse(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/response")
    public ResponseEntity<Response> getResponse(@RequestBody Question question) {
        return new ResponseEntity<>(chatService.sendResponse(question), HttpStatus.OK);
    }
}
