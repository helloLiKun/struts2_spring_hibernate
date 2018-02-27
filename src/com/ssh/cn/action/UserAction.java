package com.ssh.cn.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by likun on 2018/2/26 0026.
 */
@Controller
@Scope("prototype")
public class UserAction {
    public String execute(){
        System.out.println("---------------execute------------------");
        return "success";
    }

    public void a(){
        System.out.println("---------------a is invoke------------------");
    }

    public void b(){
        System.out.println("---------------b is invoke------------------");
    }
}
