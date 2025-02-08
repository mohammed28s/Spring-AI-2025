package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.Answer;
import guru.springframework.springaiintro.model.GetCapitalRequest;
import guru.springframework.springaiintro.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * Created by mohammed, Spring Framework Guru.
 */


@Service
public class OpenAIServiceImpl implements OpenAIService{


    private final ChatModel chatModel;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;  //This is chatModel used with all types of LLM
    }


    @Override
    public Answer getAnswer(Question question) {
        System.out.println("I was Called");

        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();  //This is to create new question

        ChatResponse response = chatModel.call(prompt);  //This is to answer thr question

        return new Answer(response.getResult().getOutput().getContent());
    }


    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    @Override
    public Answer getCapital(GetCapitalRequest getCapitalRequest) {
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getCapitalRequest.stateOrCountry()));  //This is to create new question
        ChatResponse response = chatModel.call(prompt);  //This is to answer the question

        return new Answer(response.getResult().getOutput().getContent());
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();  //This is to create new question

        ChatResponse response = chatModel.call(prompt);  //This is to answer thr question

        return response.getResult().getOutput().getContent();  //These three functions for getting the answer
    }




}