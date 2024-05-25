package com.app.feepayment.service;

import com.app.feepayment.beans.CreateResponse;
import com.app.feepayment.beans.UpdateRequest;
import com.app.feepayment.beans.UserVo;
import com.app.feepayment.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public CreateResponse createUser(UserVo userVo);

    public User getUserById(Long id);

    public User getUserByName(String username);

    public ResponseEntity<String> updateUser(UpdateRequest request);

    public ResponseEntity<String> deleteUser(Long id);
}
