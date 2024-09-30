package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Unit {

    private Group group;
    private String text;
    private List<Question> questions;

}
