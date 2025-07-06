package com.phoenixhell.study.controller;

import com.phoenixhell.study.service.ChatAssistant;
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
public class DeclarativeAIServiceController {
    @Resource
    private ChatAssistant chatAssistant;

    // http://localhost:9003/lc4j/boot/declarative
    @GetMapping(value = "/lc4j/boot/declarative")
    public String declarative(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        return chatAssistant.chat(prompt);
    }
}
