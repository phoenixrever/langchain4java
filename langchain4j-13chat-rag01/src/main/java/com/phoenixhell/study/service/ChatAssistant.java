package com.phoenixhell.study.service;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-06-02 21:01
 * 
 */
public interface ChatAssistant {

    /**
     * 聊天
     *
     * @param message 消息
     * @return {@link String }
     */
    String chat(String message);
}
