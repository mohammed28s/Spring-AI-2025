package guru.springframework.springaiintro.controllers;

import guru.springframework.springaiintro.model.Answer;
import guru.springframework.springaiintro.model.Question;
import guru.springframework.springaiintro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Created by Mohammed, Spring Framework Guru
 */

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/ask")  //  http://8080/ask
    public Answer askQuestion(@RequestBody Question question) {

        return openAIService.getAnswer(question);
    }


}
