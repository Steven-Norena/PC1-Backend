package com.backend.pc1.service;

import com.backend.pc1.dto.user.LoginRequestDTO;
import com.backend.pc1.dto.user.LoginResponseDTO;
import com.backend.pc1.dto.user.RegisterRequestDTO;
import com.backend.pc1.exception.UserAlreadyExistsException;
import com.backend.pc1.model.User;
import com.backend.pc1.repository.UserRepository;
import com.backend.pc1.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                );

        String token = jwtUtils.generateToken(request.getUsername());
        int expiresInSeconds = jwtUtils.getJwtExpirationAccess() / 1000;

        return LoginResponseDTO.builder()
            .token(token)
            .expiresIn(expiresInSeconds)
            .build();
    }

    public String register(RegisterRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("El email ya está registrado.");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("El nombre de usuario ya está registrado.");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return "Usuario registrado con éxito";
    }
}
