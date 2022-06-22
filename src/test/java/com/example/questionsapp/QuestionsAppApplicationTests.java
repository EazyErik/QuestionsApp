package com.example.questionsapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionsAppApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void integrationsTest() {
        Question fistQuestion = new Question("test","answer",true);
        ResponseEntity<Question[]> response = restTemplate.getForEntity("/api/questions/", Question[].class);
        Assertions.assertThat(response.getBody()).isEmpty();


        ResponseEntity<Question> postResponse = restTemplate.postForEntity("/api/questions", fistQuestion, Question.class);
        Assertions.assertThat(postResponse.getBody().getQuestion()).isEqualTo("test");
        Assertions.assertThat(postResponse.getBody().getAnswer()).isEqualTo("answer");
        Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(postResponse.getBody().isApproved()).isEqualTo(true);

        ResponseEntity<Question> getResponse = restTemplate.getForEntity("/api/questions/" + postResponse.getBody().getId(), Question.class);
        Assertions.assertThat(getResponse.getBody()).isEqualTo(postResponse.getBody());

        restTemplate.delete("/api/questions/" + postResponse.getBody().getId(), Void.class);
        Assertions.assertThat(response.getBody().length).isEqualTo(0);






    }


}
