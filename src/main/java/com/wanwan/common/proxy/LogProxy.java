package com.wanwan.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wanwan on 2017/5/9.
 */
public class LogProxy implements InvocationHandler{
    private Object realObject;

    public Object newProxyInstance(Object realObject){
       this.realObject = realObject;
       return  Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
               realObject.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start-->>" + method.getName());
        for (int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }
        Object ret = null;
        try {
            //调用目标方法
            ret = method.invoke(realObject, args);
            System.out.println("success-->>" + method.getName());
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error-->>" + method.getName());
            throw e;
        }
        return ret;
    }
}
