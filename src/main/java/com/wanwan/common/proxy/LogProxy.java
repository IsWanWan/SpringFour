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
        /**
         * 这个方法就是生成一个代理，gei realObject 这个实力的类，第二个参数 实现它的接口，这个handler，
         * 生成的这个代理 不直接调用方法，交给handler调用。handler的invoke 调用具体方法。
         */
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
            System.out.println("success-->>" + method.getName()+ System.currentTimeMillis());
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error-->>" + method.getName());
            throw e;
        }
        return ret;
    }
}
