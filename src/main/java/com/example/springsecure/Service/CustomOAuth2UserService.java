package com.example.springsecure.Service;

import com.example.springsecure.Model.User;
import com.example.springsecure.Repository.EmployeeRepository;
import com.example.springsecure.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // Extract user details from OAuth2User
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        // Load or save the user in the database
        User user = userRepository.findByMail(email);
        if (user == null) {
            user = new User();
            user.setMail(email);
            user.setName(name);
            userRepository.save(user);
        }
        String post = employeeRepository.findById(Long.parseLong(user.getEmployee_id().toString())).get().getPost().toString();
        System.out.println("heeeeeeeeeeeeeeeeeeeeeereeeeeee");
        System.out.println("POST : " + post);

        // Return a DefaultOAuth2User with the necessary authorities and attributes
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(post)),
                oAuth2User.getAttributes(),
                "email"
        );
    }
}
