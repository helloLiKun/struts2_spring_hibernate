package com.ssh.cn.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

/**
 * Created by likun on 2018/2/27 0027.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        String username = (String) session.get("username");
        String result = null;
        System.out.println("--------------------begin------------------------");
        result = actionInvocation.invoke();
//        if(username != null && username != ""){
//            System.out.println("登录名="+username);
//
//        }
        System.out.println("--------------------end------------------------");
        return result;
    }
}
