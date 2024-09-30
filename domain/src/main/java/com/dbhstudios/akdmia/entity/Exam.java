package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Exam {

    private String text;
    private List<Question> questions;

}
