package PaymentGateway.controller;

import PaymentGateway.DTO.UserDTO;
import PaymentGateway.service.UserService;

public class UserController {
    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    public UserDTO addUser(UserDTO user){
        return userService.addUser(user);
    }

    public UserDTO getUser(int userID){
        return userService.getUser(userID);
    }
}
