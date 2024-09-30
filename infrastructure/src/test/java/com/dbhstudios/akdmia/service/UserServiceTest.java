package com.dbhstudios.akdmia.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.dbhstudios.akdmia.Application;
import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;  // Mock del repositorio

    @InjectMocks
    private UserService userService;  // Servicio a testear

    @BeforeEach
    void setUp() {
        // Inicializa los mocks antes de cada test
        MockitoAnnotations.openMocks(UserService.class);
    }

    @Test
    void testCrearUsuario() {
        // Dado que
        User userMock = new User("John Doe", "john@example.com");

        // Configuramos el comportamiento del mock
        when(userRepository.save(any(User.class))).thenReturn(userMock);

        // Cuando
        User usuarioCreado = userService.save("John Doe", "john@example.com");

        // Entonces
        assertNotNull(usuarioCreado);
        assertEquals("John Doe", usuarioCreado.getUsername());
        assertEquals("john@example.com", usuarioCreado.getEmail());

        // Verificar que se haya llamado al método guardar del repositorio
        verify(userRepository, times(1)).save(any(User.class));
    }
}