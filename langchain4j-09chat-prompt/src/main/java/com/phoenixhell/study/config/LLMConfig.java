package com.phoenixhell.study.config;

import com.phoenixhell.study.service.LawAssistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-30 21:22
 * 
 */
@Configuration
public class LLMConfig {
    @Bean
    public ChatModel chatModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwen-api"))
                .modelName("qwen-long")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public LawAssistant lawAssistant(ChatModel chatModel) {
        return AiServices.create(LawAssistant.class, chatModel);
    }
}
