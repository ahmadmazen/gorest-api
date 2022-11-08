package sa.lendo.gorest.api.Oauthresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.lendo.gorest.api.Oauthresourceserver.dto.UserDto;
import sa.lendo.gorest.api.Oauthresourceserver.service.UserService;

import java.util.List;

@RestController
public class UserController {

//    @GetMapping("/api/users")
//    public String[] getUser() {
//        return new String[]{"Shabbir", "Nikhil","Shivam"};
//    }
@Autowired
private UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> listOfUsers() throws Exception {

        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

}
