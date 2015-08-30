package cn.wyh.dm.action;

import cn.wyh.dm.entity.User;
import cn.wyh.dm.filter.Authority;
import cn.wyh.dm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Stan on 2015/8/29.
 */

@Namespace("/")
@ParentPackage("base")
@Action(value = "user")
@Results({
        @Result(name = "listUsers", type = "redirect", location = "user!listUsers.action"),
        @Result(name = "listUsers", location = "/user/list.jsp"),
        @Result(name = "add", location = "/user/edit.jsp"),
        @Result(name = "edit", location = "/user/edit.jsp"),
        @Result(name = "save", type = "redirect", location = "user!listUsers.action"),
        @Result(name = "delete", type = "redirect", location = "user!listUsers.action"),
        @Result(name = "error", location = "/error.jsp")
})
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;
    private Iterable<User> users;
    private User user;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Iterable<User> getUsers() {
        return users;
    }

    public void setUsers(Iterable<User> users) {
        this.users = users;
    }

    public String listUsers(){
        users = userService.findAll();
        return "listUsers";
    }

    public String add(){
        return "add";
    }

    public String edit() {
        this.user = userService.getUserById(this.id);
        return "edit";
    }

    public String save(){
        userService.save(user);
        return "save";
    }

    public String delete(){
        ActionContext context = ActionContext.getContext();
        Map map = context.getParameters();
        String[] params = (String[])map.get("id");
        long id = Long.parseLong(params[0]);
        userService.delete(userService.getUserById(id));
        return "delete";
    }

    public String json() {
        return "json";
    }

    public void test() {
        User user = new User();
        user.setUsername("zsd");
        user.setPassword("abc");
        userService.save(user);
    }


    public void test2() {
        User u = userService.getUser("zsd");
        System.out.println(u.toString());
    }
}
