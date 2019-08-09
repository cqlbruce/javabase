package com.sun.jvm;

import com.sun.desinpattern.CGLibBeProxy;
import com.sun.desinpattern.CGLibInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class MetaSpaceOOM {



    public static void main(String[] args) {

        while (true){

            // 代理类class文件存入本地磁盘方便我们反编译查看源码
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "A:\\temp");
            // 通过CGLIB动态代理获取代理对象的过程
            Enhancer enhancer = new Enhancer();
            // 设置enhancer对象的父类
            enhancer.setSuperclass(CGLibBeProxy.class);
            // 设置enhancer的回调对象
            enhancer.setCallback(new CGLibInterceptor());
            // 创建代理对象
            CGLibBeProxy proxy= (CGLibBeProxy)enhancer.create();
            // 通过代理对象调用目标方法
            proxy.ordinaryMethod();
            proxy.finalMethod("hello");

        }


    }


}
