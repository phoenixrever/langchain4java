package com.phoenixhell.study.controller;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.output.TokenUsage;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-28 12:38
 * 
 */
@RestController
@Slf4j
public class LowApiController {
    @Resource(name = "gemini")
    private ChatModel chatModelGemini;

    @Resource(name = "openai")
    private ChatModel chatModelOpenAI;

    @GetMapping(value = "/lowapi/api01")
    public String api01(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        String result = chatModelGemini.chat(prompt);

        System.out.println("通过langchain4j调用模型返回结果：" + result);

        return result;
    }

    // http://localhost:9004/lowapi/api02

    /**
     * @Description: Token 用量计算的底层api演示验证案例
     * @Auther: チヨウ　カツヒ
     */
    @GetMapping(value = "/lowapi/api02")
    public String api02(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        ChatResponse chatResponse = chatModelOpenAI.chat(UserMessage.from(prompt));

        String result = chatResponse.aiMessage().text();
        System.out.println("通过调用大模型返回结果：" + result);

        // Token 用量计算的底层api
        TokenUsage tokenUsage = chatResponse.tokenUsage();

        System.out.println("本次调用消耗的token：" + tokenUsage);

        result = result + "\t\n" + tokenUsage;

        return result;
    }

}
