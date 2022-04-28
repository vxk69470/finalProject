package com.demo.finalproject.service;

import javax.transaction.Transactional;

import com.demo.finalproject.model.UserDetailsImpl;
import com.demo.finalproject.model.User;
import com.demo.finalproject.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with "
                        + "user name " + username + " not found"));
        return UserDetailsImpl.createInstance(user);
    }
}
