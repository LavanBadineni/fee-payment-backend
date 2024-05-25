package com.app.feepayment.dao;

import com.app.feepayment.beans.CreateResponse;
import com.app.feepayment.beans.UserVo;
import com.app.feepayment.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public CreateResponse save(User user);

    public User getUserById(Long id);

    public User getUserByusername(String username);


}
