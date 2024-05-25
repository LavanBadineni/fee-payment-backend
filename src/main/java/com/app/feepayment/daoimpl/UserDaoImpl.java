package com.app.feepayment.daoimpl;

import com.app.feepayment.beans.CreateResponse;
import com.app.feepayment.dao.UserDao;
import com.app.feepayment.entity.User;
import com.app.feepayment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;


    @Override
    public CreateResponse save(User user) {

        User newUser = userRepository.save(user);
        CreateResponse response = new CreateResponse();
        response.setResponseCode(200);
        response.setResponseMessage("User details created Successfully");
        return response;
    }

    @Override
    public User getUserById(Long id) {

        Optional<User> getUser = userRepository.findById(id);
        return getUser.get();
    }

    @Override
    public User getUserByusername(String username) {

        User getUser = userRepository.findByUsername(username);

        return getUser;
    }
}
