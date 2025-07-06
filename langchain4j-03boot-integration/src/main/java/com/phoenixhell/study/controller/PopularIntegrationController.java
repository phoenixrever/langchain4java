package com.phoenixhell.study.controller;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-06-18 15:43
 * 
 */
@RestController
public class PopularIntegrationController {
    @Resource
    private ChatModel chatModel;

    // http://localhost:9003/lc4j/boot/chat
    @GetMapping(value = "/lc4j/boot/chat")
    public String chat(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        String chat = chatModel.chat(prompt);
        System.out.println(chat);
        return chat;
    }
}
