package xc.jfinal.interceptor;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class GlobalInterceptor extends Controller implements Interceptor {

	
		public void intercept(Invocation inv) {
			// TODO Auto-generated method stub
			/*System.out.println("开始拦截："+"路径："+inv.getActionKey()+" 方法"+inv.getMethodName());
			if(inv.getActionKey().startsWith("/admin")){
				if(inv.getMethodName().equals("add")){
				 inv.getController().render("/index/login.html");
				}else{
					inv.invoke();
				}
			}*/
			HttpSession session = inv.getController().getSession();
	        if(session == null){  
	            inv.getController().render("/index/login.html");  
	        }  
	        else{  
	        	String nickname = (String)session.getAttribute("nickname");  
	            if(nickname != null) {  
	                //System.out.println("hello");  
	            	inv.invoke();
	            }  
	            else {  
	                inv.getController().render("/good/login.html");  
	            }  
	        }  
		}

}
