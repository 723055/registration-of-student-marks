package org.pflb.vault.security;

import org.pflb.vault.model.User;
import org.pflb.vault.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("В базе нет такого пользователя");
        }
        return new UsersDetails(user.getLogin(), user.getPassword());
    }
}
