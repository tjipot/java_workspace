package org.fkit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.fkit.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 拦截器必须实现HandlerInterceptor接口: preHandle(), postHandle()和afterCompletion() */ 
public class AuthorizationInterceptor implements HandlerInterceptor {

	// 不拦截'/loginForm'和'/login'请求, 怀疑'IGNORE_URI'名字取错了, 应该是'INTERCEPTOR_URI';
	private static final String[] IGNORE_URI = {"/loginForm", "/login"};
	
	/** 
     * preHandle方法是进行处理器拦截用的, 该方法将在Controller处理之前进行调用,
     * 该方法的返回值为true拦截器才会继续往下执行, 该方法的返回值为false的时候整个请求就结束了(因为拦截为false)。 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("AuthorizationInterceptor preHandle --> ");
		boolean flag = false; 							// flag变量用于判断用户是否登录, 默认为false;
		String servletPath = request.getServletPath();	// 获取请求的路径进行判断;
        for (String s : IGNORE_URI) {					// 判断请求是否需要拦截;
            if (servletPath.contains(s)) {
                flag = true;							// flag为true, 说明网页路径包含在'IGNORE_URI'中, 不需要拦截;
                break;
            }
        }
        
        if (!flag){															// 进入if循环, flag为flase, 是不需要拦截的网页路径;	
        	User user = (User) request.getSession().getAttribute("user");	// 1.获取session中的用户: 把"user"理解成session的一个key;
        	if(user == null){												// 2.判断用户是否已经登录, 用户为null, 说明并不在session中(并没有登录);
        		System.out.println("1");
        		System.out.println("AuthorizationInterceptor拦截请求：");		// 如果用户没有登录, 则设置提示信息, 跳转到登录页面;
        		System.out.println("2");
        		request.setAttribute("message", "请先登录再访问网站");
        		System.out.println("3");
        		request.getRequestDispatcher("loginForm").forward(request, response);
        	}else{
        		System.out.println("AuthorizationInterceptor放行请求:");		// 如果用户已经登录(已在session中), 则验证通过, 放行;
        		flag = true;
        	}
        }
        return flag;	
	}
	
	/** 
     * 该方法将在Controller的方法调用之后执行， 方法中可以对ModelAndView进行操作 ，
     * 该方法也只能在当前Interceptor的preHandle方法的返回值为true时才会执行。 
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mv) throws Exception {
		System.out.println("AuthorizationInterceptor postHandle --> ");	
	}
	
	
	/**
     * 该方法将在整个请求完成之后执行, 主要作用是用于清理资源的,
     * 该方法也只能在当前Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		System.out.println("AuthorizationInterceptor afterCompletion --> ");
	}
}
