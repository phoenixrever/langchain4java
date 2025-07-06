package com.phoenixhell.study.config;

import com.phoenixhell.study.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-27 22:04
 * @Description: 知识出处 https://docs.langchain4j.dev/get-started
 */
@Configuration
public class LLMConfig {
    //@Bean(name = "qwen")
    //public ChatModel chatModelQwen() {
    //    return OpenAiChatModel.builder()
    //            .apiKey(System.getenv("aliQwen-api"))
    //            .modelName("qwen-plus")
    //            .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
    //            .build();
    //}
    //
    ///**
    // * @Description: 知识出处，https://api-docs.deepseek.com/zh-cn/
    // * @Auther: チヨウ　カツヒ
    // */
    //@Bean(name = "deepseek")
    //public ChatModel chatModelDeepSeek() {
    //    return
    //            OpenAiChatModel.builder()
    //                    .apiKey(System.getenv("deepseek-api"))
    //                    .modelName("deepseek-chat")
    //                    //.modelName("deepseek-reasoner")
    //                    .baseUrl("https://api.deepseek.com/v1")
    //                    .build();
    //}

    @Bean(name = "gemini")
    public ChatModel chatModelGemini() {
        //System.out.println("key:"+System.getenv("GEMINI_API_KEY"));

        return GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-2.5-flash").build();
    }

    @Bean(name = "openai")
    public ChatModel chatModelOpenAI() {
        return
                OpenAiChatModel.builder()
                        .apiKey("demo")
                        .modelName("gpt-4o-mini")
                        //.modelName("deepseek-reasoner")
                        .baseUrl("http://langchain4j.dev/demo/openai/v1")
                        .build();
    }


    // High-Api https://docs.langchain4j.dev/tutorials/ai-services#simplest-ai-service
    @Bean
    public ChatAssistant chatAssistant(@Qualifier("gemini") ChatModel chatModelGemini) {
        return AiServices.create(ChatAssistant.class, chatModelGemini);
    }
}
