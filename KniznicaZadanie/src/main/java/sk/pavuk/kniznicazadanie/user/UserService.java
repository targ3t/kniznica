package sk.pavuk.kniznicazadanie.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
       return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email je zabraty");
        }
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Integer userId, String email, String heslo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("email je zabraty");
            }
            user.setEmail(email);
        }

        if (heslo != null && heslo.length() > 0 && !Objects.equals(user.getHeslo(), heslo)){
            user.setHeslo(heslo);
        }


    }
}
