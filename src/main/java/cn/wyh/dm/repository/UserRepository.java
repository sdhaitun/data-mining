package cn.wyh.dm.repository;

import cn.wyh.dm.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Stan on 2015/8/29.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u where u.username=:username")
    User findByName(@Param("username")String username);

//    @Query("select u from User u where u.username=:username and u.password=:password")
//    List<User> logon(@Param("username")String username, @Param("password")String password);

    @Query("select count(u) from User u where u.username=:username and u.password=:password")
    int logon(@Param("username")String username, @Param("password")String password);
}
