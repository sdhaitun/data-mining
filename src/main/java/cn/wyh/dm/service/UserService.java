package cn.wyh.dm.service;

import cn.wyh.dm.repository.UserRepository;
import cn.wyh.dm.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.Iterable;
/**
 * Created by Stan on 2015/8/29.
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByName(username);
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public boolean logon(String username, String password) {
        return userRepository.logon(username, password) != 0;
    }

    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
