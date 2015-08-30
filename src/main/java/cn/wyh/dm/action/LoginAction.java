package cn.wyh.dm.action;

import cn.wyh.dm.entity.User;
import cn.wyh.dm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Stan on 2015/8/30.
 */
@Namespace("/")
@ParentPackage("default")
@Action(value = "login")
@Results({
        @Result(name = "logon", type = "redirect", location = "user!listUsers.action"),
        @Result(name = "error", location = "/index.jsp"),
        @Result(name = "logout", location = "/index.jsp")
})
public class LoginAction extends ActionSupport{
    @Resource
    private UserService userService;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String logon() {
        boolean queryReuslt = userService.logon(user.getUsername(),user.getPassword());
        ActionContext context = ActionContext.getContext();
        if (queryReuslt) {
            context.getSession().put("user",user);
            return "logon";
        } else {
            return "error";
        }
    }

    public String logout() {
        ActionContext context = ActionContext.getContext();
        context.getSession().remove("user");
        return "logout";
    }
}
