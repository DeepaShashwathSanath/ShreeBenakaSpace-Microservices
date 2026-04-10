package com.shreebenakaspace.user.service;

import com.shreebenakaspace.user.dto.UserDTO;
import com.shreebenakaspace.user.entity.User;
import com.shreebenakaspace.user.repository.UserRepository;
import com.shreebenakaspace.user.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

/*    public User  saveUser(User user){
        return  userRepositoryInterface.save(user);
    }*/

    /*   DTO → converted → Entity → saved → converted back → DTO */

    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        User userSave = userRepositoryInterface.save(user);

        UserDTO response = new UserDTO();
        response.setId(userSave.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;


    }

    public UserDTO getUserById(Long id) {
        User user = userRepositoryInterface.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;

    }
//  Get All users
/*    public List<User> getAllUser(){
        return userRepositoryInterface.findAll();
    }*/
    public List<UserDTO> getAllUsers() {
        return  userRepositoryInterface.findAll().stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            return userDTO;

        }).toList();
    }
//Update User
public UserDTO updateUser(Long id, UserDTO userDTO){
        User user = userRepositoryInterface.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
                user.setName(userDTO.getName());
                user.setEmail(userDTO.getEmail());
               User updated =  userRepositoryInterface.save(user);

               UserDTO response = new UserDTO();
               response.setId(updated.getId());
               response.setEmail(updated.getEmail());
               response.setName(updated.getName());

               return response;

        }
//Delete User
public void deleteUser(Long id){
      userRepositoryInterface.deleteById(id);

}







}



