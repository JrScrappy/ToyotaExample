package com.auto_shop.services;

import com.auto_shop.models.entities.User;
import com.auto_shop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository repository;

    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    public void save(Iterable<User> users) {
        for (User user : users) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        repository.saveAll(users);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User getById(String id) {
        return repository.getReferenceById(id);
    }

    public User getUserByPhoneAndPassword(String phone, String password) {
        User user = repository.getByPhone(phone);
        return (user != null && encoder.matches(password, user.getPassword())) ? user : null;
    }

    private void encodePassword(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
    }
}
