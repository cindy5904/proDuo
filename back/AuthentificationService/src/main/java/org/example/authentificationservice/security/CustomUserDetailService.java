package org.example.authentificationservice.security;

import org.example.authentificationservice.entity.UserApp;
import org.example.authentificationservice.repository.UserAppRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserAppRepository userAppRepository;

    public CustomUserDetailService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserApp> userAppOptional = userAppRepository.findByEmail(email);
        if (userAppOptional.isPresent()){
            UserApp userApp = userAppOptional.get();
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("user"));
            return new User(userApp.getEmail(), userApp.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
