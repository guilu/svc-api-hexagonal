package com.dbhstudios.akdmia.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Answer {

    private Question question;
    private boolean ok;

}
