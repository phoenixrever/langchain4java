package com.phoenixhell.study.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-30 18:59
 * 
 */
public interface ChatAssistant {
    /**
     * @Description: 普通聊天对话，不带记忆缓存功能
     */
    String chat(String prompt);
}
