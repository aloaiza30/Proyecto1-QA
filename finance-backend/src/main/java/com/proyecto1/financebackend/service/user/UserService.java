package com.proyecto1.financebackend.service.user;



import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    public Optional<List<Category>> getUserCategories(Integer id);

    Optional<Savings> getUserSavings(Integer id);

    public Optional<User> getUserByEmail(String email);
    }


