package com.dbhstudios.akdmia.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String status;
    private String message;
}