package com.atguigu.study.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-27 22:04
 * @Description: 知识出处 https://docs.langchain4j.dev/get-started
 */
@Configuration
public class LLMConfig {

    /**
     * 由于我用的 GoogleAiGeminiChatModel 不能用 openAI协议
     * 它默认连接 OpenAI 的 API：https://api.openai.com/v1
     * 好像事项openAI的会修改baseUrl 我就不改了 知道就行了
     */
    //@Bean
    //public ChatModel chatModelQwen()
    //{
    //    return OpenAiChatModel.builder()
    //                    .apiKey(System.getenv("aliQwen-api"))
    //                    .modelName("qwen-plus")
    //                    .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
    //            .build();
    //}


    /**
     * @author チヨウ　カツヒ
     * @email phoenixrever@gmail.com
     * @date 2025/07/06 16:20
     * <p>
     * 模型用 gemini-2.5-flash
     */
    @Bean
    public ChatModel chatModelGemini() {
        //System.out.println("key:"+System.getenv("GEMINI_API_KEY"));

        return GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-2.5-flash").build();
    }
}
