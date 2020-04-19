package com.yc.biz;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogCglibProxy implements MethodInterceptor {

	private Object target;

	// 创建代理类的对象.
	public Object createProxy(Object target) {
		this.target = target;

		//Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(    this  );
		
		return enhancer.create();
		
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] params, MethodProxy arg3) throws Throwable {
		Object returnValue=null;
		if( ! method.getName().startsWith("find")) {     //切入点表达式     ->  antlr  ->  解析 切入点表达式
			 returnValue=method.invoke(target, params);
		}
		log();
		return returnValue;
	}
	
	//增强 
	private void log() {
		System.out.println("=====后置增强 ======");
		System.out.println(new Date());
		System.out.println("=====+++++++ ======");
	}

}
