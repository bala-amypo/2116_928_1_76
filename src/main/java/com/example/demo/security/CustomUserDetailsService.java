package com.example.demo.security;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonProfileRepository repo;

    // ✅ REQUIRED by tests
    public CustomUserDetailsService(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        PersonProfile user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserPrincipal(user);
    }

    // ✅ REQUIRED by tests
    public PersonProfile register(String name, String email, String password) {
        PersonProfile p = new PersonProfile();
        p.setFullName(name);
        p.setEmail(email);
        p.setReferenceId(email);
        return repo.save(p);
    }
}
