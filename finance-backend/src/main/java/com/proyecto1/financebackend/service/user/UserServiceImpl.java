package com.proyecto1.financebackend.service.user;

import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.model.User;
import com.proyecto1.financebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<List<Category>> getUserCategories(Integer id) {
        Optional<User> user = userRepository.findAllById(Collections.singleton(id)).stream().findFirst();
        user.get().getCategories();
        return user.map(User::getCategories);
    }

    @Override
    public Optional<Savings> getUserSavings(Integer id) {
        Optional<User> user = userRepository.findAllById(Collections.singleton(id)).stream().findFirst();
        return user.map(User::getSavings);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.selectByEmail(email).stream().findFirst();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


}
