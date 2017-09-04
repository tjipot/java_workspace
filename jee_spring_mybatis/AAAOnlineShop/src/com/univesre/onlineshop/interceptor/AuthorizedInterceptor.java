package com.univesre.onlineshop.interceptor;

import com.univesre.onlineshop.domain.ShopMember;
import com.univesre.onlineshop.util.common.OnlineShopConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizedInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URI = { "/LoginForm" };	// 哈哈, 自设乌龙?!, 一定要把LoginForm设为不拦截的范围, 要不然永远别登陆了; "/mainpage", , "/LoginFormAdmin"

	/** 记住,request和response对象都是容器包装好'传送'过来的,也是javax包定义中定义好了的  */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag = false;
		String servletPath = request.getServletPath();	// 从当前页面的request中取得URI路径;
		for(String s : IGNORE_URI) {
			if(servletPath.contains(s)) {				// 如果包含path, 则是IGNORE中的几个, flag为true说明路径不需要拦截, break退出for循环;
				flag = true;
				break;
			}
		}
		
		if(!flag) {										// Session是request中自带的'功能', 在客户端上, 则由浏览器'自动'设置, 无需过多操心;
			ShopMember shopMember = (ShopMember) request.getSession().getAttribute(OnlineShopConstants.USER_SESSION);	// "user_session"会话;
			if(shopMember == null) {					// 说明Session中没有一个shopMember;
				System.out.println("1");
				request.setAttribute("Message", "Pls login first..");	// Key-Value Pair;
				System.out.println("2");
				request.getRequestDispatcher(OnlineShopConstants.LOGIN).forward(request, response);		// 因为没有Session就没有'登录', '转发'请求到'LoginForm';
				System.out.println("3");
				return flag;																			// 先RequestDispatcher跳转页面再forward()把先前的request和response也一并传过去;
			}else{
				flag = true;																			// 执行到这个else里, 假设flag为true(已登录);
			}
		}
		return flag;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub	
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub	
	}
	
}
