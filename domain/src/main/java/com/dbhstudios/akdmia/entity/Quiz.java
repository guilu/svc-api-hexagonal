package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Quiz{

    private boolean ended;
    private List<QuizQuestion> quizQuestions;
    private int correct;
    private int failed;
    private int numQuestionsByUnit;
    private int numQuestionsTotal;

}
