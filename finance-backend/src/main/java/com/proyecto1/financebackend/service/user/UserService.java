package com.proyecto1.financebackend.service.user;



import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<List<Category>> getUserCategories(Integer id);

    Optional<Savings> getUserSavings(Integer id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(Integer id);

    void deleteUser(Integer id);



    }


