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

        //1���жϿͻ��Ƿ��½

        //��session��ȡ��ǰ�ͻ���Ϣ
        User user = (User) ActionContext.getContext().getSession().get("user");
        if(user == null){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("�ͻ���û��½���½�ѳ�ʱ������");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            return "index";
        }
        return actionInvocation.invoke();
/**
        //2������Ȩ�޿����ж�

        //��������󷽷�����Ҫ������֤������ִ�������߼�
        if(currentMethod.isAnnotationPresent(Authority.class)){
            //��ȡȨ��У���ע��
            Authority authority=currentMethod.getAnnotation(Authority.class);
            //��ȡ��ǰ�����ע���actionName
            String actionName=authority.actionName();
            //��ȡ��ǰ������Ҫ��Ȩ��
            String privilege=authority.privilege();

            //�����ڴ��жϵ�ǰ�ͻ��Ƿ�ӵ�ж�Ӧ��Ȩ�ޣ����û�п�������ָ������Ȩ����ʾҳ�棬���ӵ������Լ�������ִ�С�

            //if(ӵ�ж�Ӧ��Ȩ��){
            //    return actionInvocation.invoke();
            //}else{
            //    return "��Ȩ��";
            //}

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("�ͻ�" + user.getUsername() + "��" + new Date() + "ִ����" + actionName+"������ӵ��"+ privilege +"Ȩ�ޣ���");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            return actionInvocation.invoke();
        }

        //3�����з�Ȩ�޿����ж�

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("��ִ����û�У���");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return "index";*/
    }
}
