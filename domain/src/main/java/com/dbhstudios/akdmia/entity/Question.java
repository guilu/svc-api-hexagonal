package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Question {

    private Unit unit;
    private String text;
    private List<Answer> answers;
    private Exam exam;

}
