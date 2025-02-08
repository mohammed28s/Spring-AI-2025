package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.Answer;
import guru.springframework.springaiintro.model.GetCapitalRequest;
import guru.springframework.springaiintro.model.Question;

/**
 * Created by mohammed, Spring Framework Guru.
 */


public interface OpenAIService {

    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);

    Answer getCapital(GetCapitalRequest getCapitalRequest);

    String getAnswer(String question);

    Answer getAnswer(Question question);
}
