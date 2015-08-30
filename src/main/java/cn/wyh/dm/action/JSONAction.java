package cn.wyh.dm.action;

import cn.wyh.dm.entity.User;
import cn.wyh.dm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Stan on 2015/8/30.
 */
@Result(name="success", type="json", params = {"root", "json"})
@ParentPackage("default")
@Namespace("/")
public class JSONAction extends ActionSupport{
    @Resource
    private UserService userService;
//    private static final long serialVersionUID = 1L;

    public Map<String, Object> getJson() {
        return json;
    }

    public void setJson(Map<String, Object> json) {
        this.json = json;
    }

    private Map<String, Object> json =  new HashMap<String, Object>();

    //private List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();

    @Action("/json-listUsers")
    public String listUsers() {
        Iterable<User> users = userService.findAll();
        json.put("users", users);
//        json.add(map);
        return SUCCESS;
    }

}
