package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizQuestion {

    private Quiz quiz;
    private Question question;

    private boolean correct;

}
