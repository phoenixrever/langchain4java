package com.phoenixhell.study.service;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-28 17:28
 * @Description: 我们知道，按照Java开发一般习惯，有接口就要有实现类
 * 比如接口ChatAssistant，就会有实现类ChatAssistantImpl
 * 现在用高阶api-AIServics不用你自己写impl实现类，交给langchain4j给你搞定
 * <p>
 * 本次配置用的是langchain4j原生整合，没有引入sprinboot，不需要接口头上配置@AiService注解标签
 *
 * 注意 @AiService 是整合了springboot langchain包 才有的 这里面我们需要
 *  AiServices.create(ChatAssistant.class, chatModelGemini);
 *  手动在config中创建注入到容器中
 */
public interface ChatAssistant {
    /**
     * 这个接口的方法名字
     * 帮助构造语义明确的 prompt，以提高模型的理解能力。名字越清晰、越贴近意图，模型输出越精准。
     *
     * 方法名会被框架用于构造 prompt 的一部分，帮助大语言模型理解“你想让它做什么”。
     */
    String chat(String prompt);
}
