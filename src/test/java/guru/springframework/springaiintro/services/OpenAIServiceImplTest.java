package guru.springframework.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    OpenAIServiceImpl openAIService;

    @Test
    void getAnswer(){

        String answer = openAIService.getAnswer("What are the most common types of cyber attacks?");
        System.out.println("Got the answer: "+"\n");
        System.out.println(answer);

    }






}