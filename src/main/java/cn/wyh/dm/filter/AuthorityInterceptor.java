package cn.wyh.dm.filter;

import java.lang.reflect.Method;
import java.util.Date;

import cn.wyh.dm.entity.User;
import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * Created by Stan on 2015/8/30.
 */
public class AuthorityInterceptor implements Interceptor {
    public void destroy() {

    }

    public void init() {

    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String methodName = actionInvocation.getProxy().getMethod();
        Method currentMethod = actionInvocation.getAction()
                .getClass().getMethod(methodName, null);

        //1、判断客户是否登陆

        //从session获取当前客户信息
        User user = (User) ActionContext.getContext().getSession().get("user");
        if(user == null){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("客户还没登陆或登陆已超时！！！");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            return "index";
        }
        return actionInvocation.invoke();
/**
        //2、进行权限控制判断

        //如果该请求方法是需要进行验证的则需执行以下逻辑
        if(currentMethod.isAnnotationPresent(Authority.class)){
            //获取权限校验的注解
            Authority authority=currentMethod.getAnnotation(Authority.class);
            //获取当前请求的注解的actionName
            String actionName=authority.actionName();
            //获取当前请求需要的权限
            String privilege=authority.privilege();

            //可以在此判断当前客户是否拥有对应的权限，如果没有可以跳到指定的无权限提示页面，如果拥有则可以继续往下执行。

            //if(拥有对应的权限){
            //    return actionInvocation.invoke();
            //}else{
            //    return "无权限";
            //}

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("客户" + user.getUsername() + "在" + new Date() + "执行了" + actionName+"方法，拥有"+ privilege +"权限！！");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            return actionInvocation.invoke();
        }

        //3、进行非权限控制判断

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("我执行了没有？？");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return "index";*/
    }
}
