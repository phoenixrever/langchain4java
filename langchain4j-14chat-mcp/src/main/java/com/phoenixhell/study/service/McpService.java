package com.phoenixhell.study.service;

import reactor.core.publisher.Flux;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-06-02 21:39
 * 
 */
public interface McpService {
    Flux<String> chat(String question);
}
