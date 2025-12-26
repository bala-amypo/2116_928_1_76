package com.example.demo.security;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonProfileRepository personProfileRepository;

    public CustomUserDetailsService(PersonProfileRepository personProfileRepository) {
        this.personProfileRepository = personProfileRepository;
    }

    // ✅ REQUIRED BY SPRING SECURITY
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonProfile user = personProfileRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new UserPrincipal(user);
    }

    // ✅ REQUIRED BY TEST CASES
    public PersonProfile register(String name, String email, String password) {
        PersonProfile user = new PersonProfile();
        user.setFullName(name);
        user.setEmail(email);
        user.setReferenceId(email);
        return personProfileRepository.save(user);
    }
}
