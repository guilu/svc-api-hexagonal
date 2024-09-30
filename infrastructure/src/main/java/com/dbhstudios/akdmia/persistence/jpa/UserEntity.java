package com.dbhstudios.akdmia.persistence.jpa;

import com.dbhstudios.akdmia.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "TB00_USER", schema = "BDD_AKDEMY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @GeneratedValue
    @Id
    @JsonIgnore
    private Long id;

    @Size(max = 1024)
    @Column
    private String username;

    @Size(max = 1024)
    @Column
    private String email;

    public UserEntity(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User toObject(){
        return new User(this.username, this.email);
    }

}
