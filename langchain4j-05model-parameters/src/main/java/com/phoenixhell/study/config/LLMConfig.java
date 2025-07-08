package com.phoenixhell.study.config;

import com.phoenixhell.study.listener.TestChatModelListener;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-27 22:04
 * @Description: 知识出处 https://docs.langchain4j.dev/tutorials/model-parameters/
 *
 * # langchain4j openao free demo key https://docs.langchain4j.dev/integrations/language-models/open-ai#api-key
 */
@Configuration
public class LLMConfig {
    @Bean(name = "openai")
    public ChatModel chatModelOpenAI() {
        return OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .logRequests(true) // 日志级别设置为debug才有效 logging.level.dev.langchain4j=DEBUG
                .logResponses(true)// 日志级别设置为debug才有效 logging.level.dev.langchain4j=DEBUG
                .listeners(List.of(new TestChatModelListener()))
                .maxRetries(2)
                .timeout(Duration.ofSeconds(2))//向大模型发送请求时，如在指定时间内没有收到响应，该请求将被中断并报request timed out
                .build();
    }
}
