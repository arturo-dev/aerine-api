package com.arturo.aerineapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.arturo.aerineapi.user.User user = userRepository.findOneByUsername(username);
        UserDetails loged = null;

        if (user != null) {
            loged = new User(
                    user.getId().toHexString(), 
                    user.getPassword(), 
                    user.getEnabled(),
                    user.getAccountNonExpired(),
                    user.getCredentialsNonExpired(),
                    user.getAccountNonLocked(),
                    user.getAuthorities());
        }

        return loged;
    }

}