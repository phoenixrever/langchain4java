package com.atguigu.study.controller;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-27 21:43
 */
@RestController
@Slf4j
public class HelloLangChain4JController {
    // http://localhost:9001/langchain4j/hello?question=如何学习java

    @Resource
    private ChatModel chatModel;

    @GetMapping(value = "/langchain4j/hello")
    public String hello(@RequestParam(value = "question", defaultValue = "你是谁") String question) {
        String result = chatModel.chat(question);

        System.out.println("调用大模型回复: " + result);

        return result;
    }

    @GetMapping(value = "/langchain4j/hello2")
    public String hello2(@RequestParam(value = "question", defaultValue = "你是谁") String question) {

        /**
         * - **本质**：你自己创建一个完整的 `ChatRequest` 请求对象。
         * - **优势**：
         *     - 可以添加多个 `messages`，实现多轮对话。
         *     - 可以支持 `SystemMessage`（设定角色行为）。
         *     - 更适合和 LangChain 的其他组件配合。
         */
        ChatResponse chatResponse = chatModel.chat(ChatRequest.builder()
                .messages(UserMessage.from(question))
                .build());

        String response = chatResponse.aiMessage().text();

        System.out.println("调用大模型回复: " + response);

        return response;
    }
}
