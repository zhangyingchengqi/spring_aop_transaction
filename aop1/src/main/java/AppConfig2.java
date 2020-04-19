
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.yc.biz.UserBiz;
import com.yc.biz.UserBizImpl;

@Configuration
@ComponentScan(basePackages = "com.yc")
@EnableAspectJAutoProxy
public class AppConfig2 {
	

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
		
		UserBizImpl ub=(UserBizImpl) ctx.getBean("userBizImpl");  //  jdk: 面向接口 $Proxy28    可以对代理类再代理
		           //   CGLIB&&xxxxxx      cglib:代理，面向继承        //只能代理一层
		//ub.addUser("zy","a");
		
		//ub.deleteUser();
		
		//ub.updateUser();
		
		double r=ub.findUser();
		System.out.println(  r );
		
	}
}
