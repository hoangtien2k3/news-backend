package com.hoangtien2k3.userservice.security.userprinciple;

import com.hoangtien2k3.userservice.entity.User;
import com.hoangtien2k3.userservice.exception.wrapper.EmailOrUsernameNotFoundException;
import com.hoangtien2k3.userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found, username and passowrd: " + username));

        return UserPrinciple.build(user);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("Email or Username does not exist, please try again: " + email));

        return UserPrinciple.build(user);
    }

}
