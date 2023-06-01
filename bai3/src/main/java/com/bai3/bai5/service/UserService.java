package com.bai3.bai5.service;

import com.bai3.bai5.entity.User;
import com.bai3.bai5.repository.IRoleRepository;
import com.bai3.bai5.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public boolean isValidUser(String username, String password) {
        // Lấy thông tin người dùng từ nguồn dữ liệu (ví dụ: cơ sở dữ liệu)
        User user = userRepository.findByUsername(username);

        // Kiểm tra xem người dùng có tồn tại và mật khẩu khớp hay không
        if (user != null && user.getPassword().equals(password)) {
            return true; // Đăng nhập thành công
        }

        return false; // Đăng nhập không thành công
    }

    public  User getUserById(Long id){
        Optional<User> User= userRepository.findById(id);
        return User.orElse(null);
    }
    @Transactional
    public void save(User User){
        userRepository.save(User);
        Long userID=userRepository.getUserIdByUsername(User.getUsername());
        Long roleID= roleRepository.getRoleIdByName("USER");
        if(roleID!=0 &&userID!=0) userRepository.addRoleToUser(userID,roleID);

    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
