package com.dbhstudios.akdmia.rest.inbound;

import com.dbhstudios.akdmia.dto.UserRequest;
import com.dbhstudios.akdmia.dto.UserResponse;
import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AkdemiaController {

    private UserService userService;

    @GetMapping("/hola")
    public ResponseEntity<User> index(UserRequest userRequest) {
        String username="hola";
        String email="hola@gmail.com";
        return ResponseEntity.ok(userService.save(username, email));
    }
}
