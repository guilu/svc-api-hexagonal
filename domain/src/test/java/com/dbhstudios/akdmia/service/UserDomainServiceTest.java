package com.dbhstudios.akdmia.service;

import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class UserDomainServiceTest {

    private UserDomainService userDomainService;
    private UserRepository userRepository;  // Dependencia simulada (mock)

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);  // Mockear el repositorio
        userDomainService = new UserDomainService(userRepository);  // Inyectar el mock en el servicio
    }

    @Test
    void testCreateUserSuccess() {
        // Simular que no existe un usuario con el email dado
        Mockito.when(userRepository.existsByEmail("john@example.com")).thenReturn(false);

        User user = userDomainService.createUser("John Doe", "john@example.com");

        // Verificar que el usuario se haya guardado y no sea null
        Assertions.assertNotNull(user);
        Assertions.assertEquals("John Doe", user.getUsername());
        Mockito.verify(userRepository).save(user);  // Verificar que el repositorio haya guardado el usuario
    }

    @Test
    void testCreateUserEmailInUse() {
        // Simular que ya existe un usuario con el email dado
        Mockito.when(userRepository.existsByEmail("john@example.com")).thenReturn(true);

        // Verificar que se lance una excepción si el email está en uso
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userDomainService.createUser("John Doe", "john@example.com");
        });
    }
}