package com.example.springsecure.Service;

import com.example.springsecure.Model.User;
import com.example.springsecure.Repository.EmployeeRepository;
import com.example.springsecure.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByMail(username);
        System.out.println("Name : "+ user.getName());
        System.out.println("Pass : "+ user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String post = employeeRepository.findById(Long.parseLong(user.getEmployee_id().toString())).get().getPost().toString();

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getMail())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(post) // You can load roles from database as well
                .accountLocked(false) // You may need to customize this based on your logic
                .build();
    }


}
