package com.phoenixhell.study.config;

import com.phoenixhell.study.service.ChatAssistant;
import com.phoenixhell.study.service.ChatMemoryAssistant;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.TokenCountEstimator;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-30 18:58
 * @Description: 知识出处，https://docs.langchain4j.dev/tutorials/chat-memory/#eviction-policy
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

    @Bean(name = "chat")
    public ChatAssistant chatAssistant(ChatModel chatModel) {
        return AiServices.create(ChatAssistant.class, chatModel);
    }


    /**
     * @Description: 按照MessageWindowChatMemory, 当堂编码给学生演示
     * 知识出处，https://docs.langchain4j.dev/tutorials/chat-memory/#eviction-policy
     * @Auther: チヨウ　カツヒ
     */
    @Bean(name = "chatMessageWindowChatMemory")
    public ChatMemoryAssistant chatMessageWindowChatMemory(ChatModel chatModel) {

        return AiServices.builder(ChatMemoryAssistant.class)
                .chatModel(chatModel)
                //按照memoryId对应创建了一个chatMemory
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(100))
                .build();
    }

    /**
     * @Description: 按照TokenWindowChatMemory, 当堂编码给学生演示
     * 知识出处，https://docs.langchain4j.dev/tutorials/chat-memory/#eviction-policy
     * @Auther: チヨウ　カツヒ
     */
    @Bean(name = "chatTokenWindowChatMemory")
    public ChatMemoryAssistant chatTokenWindowChatMemory(ChatModel chatModel) {
        //1 TokenCountEstimator默认的token分词器，需要结合Tokenizer计算ChatMessage的token数量
        TokenCountEstimator openAiTokenCountEstimator = new OpenAiTokenCountEstimator("gpt-4");

        return AiServices.builder(ChatMemoryAssistant.class)
                .chatModel(chatModel)
                .chatMemoryProvider(memoryId -> TokenWindowChatMemory.withMaxTokens(1000, openAiTokenCountEstimator))
                .build();
    }
}
