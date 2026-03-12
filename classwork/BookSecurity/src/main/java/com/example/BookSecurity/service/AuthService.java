
package com.example.BookSecurity.service;
import com.example.BookSecurity.DTO.AuthResponse;
import com.example.BookSecurity.DTO.LoginRequest;
import com.example.BookSecurity.DTO.RegisterRequest;
import com.example.BookSecurity.entity.Role;
import com.example.BookSecurity.entity.User;
import com.example.BookSecurity.repository.UserRepository;
import com.example.BookSecurity.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public String register(RegisterRequest request) {

        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());

        return new AuthResponse(token, user.getUsername(), user.getRole().name());
    }
}