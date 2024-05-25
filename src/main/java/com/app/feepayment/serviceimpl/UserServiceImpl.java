package com.app.feepayment.serviceimpl;

import com.app.feepayment.beans.CreateResponse;
import com.app.feepayment.beans.UpdateRequest;
import com.app.feepayment.beans.UserVo;
import com.app.feepayment.dao.UserDao;
import com.app.feepayment.entity.User;
import com.app.feepayment.exceptions.InputInvalidException;
import com.app.feepayment.exceptions.UserNotFoundException;
import com.app.feepayment.repository.UserRepository;
import com.app.feepayment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserRepository userRepository;

    @Override
    public CreateResponse createUser(UserVo userVo) {
        User user = new User();
        user.setUsername(userVo.getUsername());
        user.setEmail(userVo.getEmail());
        user.setPassword(user.getPassword());
        user.setRole(userVo.getRole());
        user.setFirstName(userVo.getFirstName());
        user.setLastName(userVo.getLastName());
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        CreateResponse response = userDao.save(user);

        return response;
    }

    @Override
    public User getUserById(Long id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public User getUserByName(String username) {
        User user = userDao.getUserByusername(username);
        return user;
    }

    @Override
    public ResponseEntity<String> updateUser(UpdateRequest request) {

        if(request.getId()==null){
            new InputInvalidException("Input credentials missing");
        }

        User user = userDao.getUserById(request.getId());
        if(ObjectUtils.isEmpty(user)){
            new UserNotFoundException("User details Not found");
        }

        if(request.getUsername() != null){
            user.setUsername(request.getUsername());
        }
        if(request.getPassword() != null){
            user.setPassword(request.getPassword());
        }
        if(request.getFirstName() != null){
            user.setFirstName(request.getFirstName());
        }
        if(request.getLastName()!=null){
            user.setLastName(request.getLastName());
        }
        if(request.getEmail()!=null){
            user.setLastName(request.getEmail());
        }
        if(request.getRole()!=null){
            user.setRole(request.getRole());
        }
     CreateResponse userAfterUpdate = userDao.save(user);

        if(userAfterUpdate != null){
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }


        return new ResponseEntity<>("Error While updating",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        if(id==null){
            new InputInvalidException("Invalid Credentials");
        }
        try {
            userRepository.deleteById(id);
        }
        catch (Exception e){
            return  new ResponseEntity<>("Error while deleting",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
