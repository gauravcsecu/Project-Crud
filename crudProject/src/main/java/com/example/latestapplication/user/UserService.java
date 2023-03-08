package com.example.latestapplication.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> listALl() {
      return (List<User>) userRepository.findAll();
    }

    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Integer id) throws  UserNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find User" + id);
    }

    @Transactional
    public void deleteUser(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if((count==null) || (count == 0)) {
            throw new UserNotFoundException("Could not find User" + id);
        } else
            userRepository.deleteById(id);
    }
}
