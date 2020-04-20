package com.yc.aspects;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//POJO

@Aspect   //声明切面:    一个关注点的模块(   切入点表达式和增强类型，增强的实现  )
@Component
public class ShowTimeAspect {
	
	public ShowTimeAspect() {
		System.out.println("ShowTimeAspect的构造方法:  单例 ,  not lazy ");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("showTimeAspect 的  init");
	}

	//切入点表达式    :  声明可以加入增强的位置      spring只支持方法级的增强
	@Pointcut("execution(* com.yc.biz.*.*(..))") // 切入点表达式
	private void anyOldTransfer() {
	}

	//前置增强
	@Before("execution(* com.yc.biz.*.*(..))")
	@Order(value=777)
	public void toShowTime(JoinPoint jp   ) {   // JointPoint联接对象:  想记录当前是哪个目标类的哪个方法及参数的话.
		System.out.println("=============");
		System.out.println("时间:"+new Date());
		Object [] objs=jp.getArgs();
		if( objs!=null&&objs.length>0) {
			System.out.println("参数:");
			for( Object obj:objs) {
				System.out.println(   obj );
			}
		}
		Object target=jp.getTarget();
		System.out.println(   "目标类:"+ target);
		Object proxy=jp.getThis();
		System.out.println("代理类:"+ proxy );
		System.out.println("=============");
	}
	
	//@AfterReturning("execution(* com.yc.biz.*.update*(..)) ")
	public void toShowBye1() {
		System.out.println("=============");
		System.out.println("bye   ");
		System.out.println("=============");
	}
	
	//@AfterThrowing("execution(* com.yc.biz.*.update*(..)) ")
	public void toShowBye2() {
		System.out.println("???????????????");
		System.out.println("bye   ");
		System.out.println("???????????????");
	}
	
	@After("execution(* com.yc.biz.*.*(..)) ")
	@Order(value=888)
	public void toShowBye3() {
		System.out.println("???????????????");
		System.out.println("bye   ");
		System.out.println("???????????????");
	}
	
	@Around("execution(* com.yc.biz.*.*(..))")
	@Order(value=1000)
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
       long start=System.currentTimeMillis();
        Object retVal = pjp.proceed();   //调用目标类的目标方法
        long end=System.currentTimeMillis();
        
        System.out.println("+++++++++++");
		System.out.println("运行时间: "+(end-start));
		System.out.println("+++++++++");
        
        return retVal;
    }
	
	
	
	
	
	
}
