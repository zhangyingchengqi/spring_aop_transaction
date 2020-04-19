import com.yc.biz.UserBiz;
import com.yc.biz.UserBizImpl;
import com.yc.proxy.LogProxy;


public class Test {

	public static void main(String[] args) {
		UserBizImpl ub=new UserBizImpl();
		ub.addUser("zy", "a");
		
		
		LogProxy lp=new LogProxy();
		UserBiz ubWithLog=(UserBiz) lp.createProxy(ub);
		ubWithLog.addUser("zy", "a");  // ->   LogProxy.inovke()  -> 完成增强的调用.      =method.invoke(target, args);调用目标类对象的目标方法
		
		
		ubWithLog.deleteUser();
		
		ubWithLog.findUser();
	}

}
