//package com.plannerapp.myplannerproject.service.impl;
//
//import com.plannerapp.myplannerproject.model.entity.User;
//import com.plannerapp.myplannerproject.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public UserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username)
//                .map(this::map)
//                .orElseThrow( ()->{throw new UsernameNotFoundException("User" + username + "not found!");});
//    }
//
//    private UserDetails map(User user){
//       return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(List.of())
//                .build();
//    }
//
//
//
//}
