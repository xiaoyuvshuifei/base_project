package com.bp.baseProject.Filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {

//	@Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//	
//	@Value("${swagger.filter}")
//	private  boolean swaggerFilter; 
//	
//	
//	private  final static List<String> whiteList;
//	static{
//		whiteList = new ArrayList<String>();
//		whiteList.add("adminLogin");
//		whiteList.add("userLogin");
//		
//		
//		
//	}
	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse response = crossFilter(arg1);
		HttpServletRequest request = (HttpServletRequest) arg0;

		/*if(request.getMethod().equals("OPTIONS")){
			response.setStatus(HttpStatus.SC_OK);
			response.getWriter().write("OK");
			return;
		}*/
//		
//		if(!swaggerFilter){
//			/**
//			 * swagger-ui
//			 */
//			whiteList.add("swagger-ui.html");
//			whiteList.add("webjars");
//			whiteList.add("swagger-resources");
//			whiteList.add("v2");
////			arg2.doFilter(request, response);
////			return;
//		}
//		
//		String uri = request.getRequestURI();
//		String whiteUri ;
//		if(uri != null && !"".equals(uri)){
//			whiteUri = uri.split("/")[1];
//		}else{
//			response.setCharacterEncoding("UTF-8");    
//			response.setContentType("application/json;charset=UTF8");
//			PrintWriter writer = response.getWriter();
//			ResultVO<String> resultVO = new ResultVO<String>("004","404");
//			writer.write(JSON.toJSONString(resultVO));
//			writer.close();
//			return;
//		}
//		if(whiteList.contains(whiteUri)){
//			arg2.doFilter(request, response);
//			return;
//		}
//		String token = request.getHeader("token");
//		String token = "52b26ecd-e457-41c7-bd85-88496bf343ba";
//		Map<Object , Object> map = redisTemplate.opsForHash().entries(token);
//		System.out.println(map);
//		boolean bool = redisTemplate.hasKey(token);
//		System.out.println(bool);
		
		
		
//		HttpSession session = request.getSession();
//		List<Integer> roleIds = new ArrayList<Integer>();
//		if(session.getAttribute("roleIds") != null){
//			roleIds = (List<Integer>)session.getAttribute("roleIds");
//		}
//		if(roleIds.size() == 0){
//			response.setCharacterEncoding("UTF-8");    
//			response.setContentType("application/json;charset=UTF8");
//			PrintWriter writer = response.getWriter();
//			ResultVO<String> resultVO = new ResultVO<String>("005","login again");
//			writer.write(JSON.toJSONString(resultVO));
//			writer.close();
//			return;
//		}
        arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	private HttpServletResponse crossFilter(ServletResponse arg1){
		HttpServletResponse response = (HttpServletResponse) arg1;
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        //response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,Authorization,Accept,User-Agent,Referer,Token");
        //response.setHeader("Access-Control-Request-Headers", "Origin, X-Requested-With, content-Type, Accept, Authorization");
		response.setHeader("Access-Control-Allow-Credentials","true");
        return response;
	}
	


}
