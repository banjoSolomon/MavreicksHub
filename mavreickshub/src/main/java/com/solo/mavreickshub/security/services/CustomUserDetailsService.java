package com.solo.mavreickshub.security.services;

import com.solo.mavreickshub.exception.UserNotFoundException;
import com.solo.mavreickshub.models.User;
import com.solo.mavreickshub.security.models.SecureUser;
import com.solo.mavreickshub.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUserByUsername(username);
            return new SecureUser(user);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
