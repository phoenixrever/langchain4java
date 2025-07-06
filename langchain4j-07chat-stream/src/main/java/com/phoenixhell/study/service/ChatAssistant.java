package com.phoenixhell.study.service;

import reactor.core.publisher.Flux;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-30 16:19
 * 
 */
public interface ChatAssistant {
    String chat(String prompt);

    Flux<String> chatFlux(String prompt);
}
