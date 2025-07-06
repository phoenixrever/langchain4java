package com.phoenixhell.study.entities;

import dev.langchain4j.model.input.structured.StructuredPrompt;
import lombok.Data;

/**
 * @auther チヨウ　カツヒ
 * @Date 2025-05-30 21:30
 * 
 */
@Data
@StructuredPrompt("根据中国{{legal}}法律，解答以下问题：{{question}}")
public class LawPrompt {
    private String legal;
    private String question;
}
