package com.phoenixhell.study.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-27 22:04
 * @Description: 知识出处 https://docs.langchain4j.dev/get-started
 *
 * 这个代码跑不通 只是演示国内模型，后面工程 openapi 和gemini 可以跑通
 */
@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwen-api"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * @Description: 知识出处，https://api-docs.deepseek.com/zh-cn/
     * @Auther: チヨウ　カツヒ
     */
    @Bean(name = "deepseek")
    public ChatModel chatModelDeepSeek() {
        return
                OpenAiChatModel.builder()
                        .apiKey(System.getenv("deepseek-api"))
                        .modelName("deepseek-chat")
                        //.modelName("deepseek-reasoner")
                        .baseUrl("https://api.deepseek.com/v1")
                        .build();
    }
}
