package PaymentGateway.service;

import PaymentGateway.DTO.UserDTO;
import PaymentGateway.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    static List<User> users;

    public UserService(){
        users = new ArrayList<User>();
    }
    public UserDTO addUser(UserDTO userDTO){
        User user = new User();
        user.setUserID((int) new Random().nextInt(100-10)+10);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        users.add(user);
        return convertUserToUserDTO(user);
    }


    public UserDTO getUser(int id){
        for(User user: users){
            if(user.getUserID() == id)
                return convertUserToUserDTO(user);
        }
        return null;
    }


    private UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

}
