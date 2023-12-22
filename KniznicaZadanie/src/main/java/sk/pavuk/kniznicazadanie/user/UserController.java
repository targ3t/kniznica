package sk.pavuk.kniznicazadanie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);

    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Integer userId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String heslo){
        userService.updateUser(userId, email, heslo);
    }
}
