package com.yc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

//代理模式
public class LogProxy implements InvocationHandler{
	//执有目标类对象的引用
	private Object target;
	
	//创建代理类的对象. 
	public Object createProxy(   Object target   ) {
		this.target=target;   //
		//   第一个参数: 目标类的类加载器
		//   第二个参数:  目标类的接口( 模板  ),因为  Proxy要根据这个模板来生成新的代理对象
		//   第三个参数:  表示 激活被调用方法 ( add ) ，自动回调  InvocationHandler实例中的  invoke
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override// 当在主程序中调用代理对象的  add(  1,2), 会自动的由jvm虚拟机回调  这里的   invoke  ()
	/**
	 * proxy: 代理类对象
	 * method: 联接点    
	 * args: 被调用的方法的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//log();  //前置增强
		//先调用目标类对象的方法
		Object returnValue=method.invoke(target, args);
		
		if( ! method.getName().startsWith("find")) {  //   execution(* com.yc.biz.*.*(..))  切入表达式   注解解析器  
			                                         //    hive: ->  select * from xxx  ->     antrl
			log();  //后置增强
		}
		
		return returnValue;
	}
	
	private void log() {
		System.out.println("=====后置增强 ======");
		System.out.println(new Date());
		System.out.println("=====+++++++ ======");
	}

}
