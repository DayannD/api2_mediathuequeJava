package mediatheque.service;

import mediatheque.entity.User;
import mediatheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(int id){
        return userRepository.findById(id).get();
    }
}
