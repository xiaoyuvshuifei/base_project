package com.bp.baseProject.controller;

import com.bp.baseProject.entity.AdminUser;
import com.bp.baseProject.entity.vo.ResultVO;
import com.bp.baseProject.service.AdminLoginService;
import com.bp.baseProject.service.AdminUserService;
import com.bp.baseProject.util.MD5Util;
import com.bp.baseProject.util.RedisUtil;
import com.bp.baseProject.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * 管理员登录
 * @author dige
 *
 */
@Api(description = "管理员登录")
@Controller
@RequestMapping(value = "/adminLogin",produces = "application/json")
public class AdminLoginController {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${admin.user.password.md5.key}")
	private  String MD5Key; 
	
	@Value("${admin.token.timeout}")
	private long tokenTimeout;
	
	@Autowired
    private RedisUtil redisUtil;
	
	@Autowired
	AdminLoginService adminLoginService;

	@Autowired
	AdminUserService adminUserService;


	/**
	 * 管理员登录
	 * @param adminUser
	 * @return
	 */
	@ApiOperation(value = "管理员登录" ,  notes="管理员登录")
	@RequestMapping(value="/adminUserLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<AdminUser> adminUserLogin(@RequestBody AdminUser adminUser){
		try {
			adminUser.setPassword(MD5Util.md5(adminUser.getPassword(), MD5Key));
		} catch (Exception e) {
			logger.error("adminUserLogin -- MD5 -- error", e);
		}
    	int checkCount = adminLoginService.checkUserPassword(adminUser);
    	ResultVO<AdminUser> resultVO = new ResultVO<AdminUser>();
    	if(checkCount == 0) {
    		resultVO.setCode("002");
    		resultVO.setMessage("账号或密码不存在");
    		return resultVO;
    	}
    	AdminUser adminUserInfo = adminUserService.selectAdminUserInfoByName(adminUser.getName());  //通过name查询用户
    	List<AdminUser> adminUsers = adminLoginService.selectAdminUserRoles(adminUser.getName());  //通过用户查询权限
    	if(adminUsers == null || adminUsers.size() == 0){
    		resultVO.setCode("003");
    		resultVO.setMessage("无权访问");
    		return resultVO;
    	}

		adminUserInfo.setRoleId(adminUsers.get(0).getRoleId());//现阶段只做一对一的角色和用户
    	String uuid = UUID.randomUUID().toString();
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("roleType", "admin");
    	map.put("userInfo", adminUserInfo);
    	map.put("token",uuid);
		redisUtil.hmset(uuid,map,tokenTimeout, TimeUnit.MINUTES);
    	resultVO.setData(map);
		resultVO.setCode("001");
		resultVO.setMessage("登录成功");
    	return resultVO;
    }
	
	
	/**
	 * 管理员登出
	 * @param adminUser
	 * @return
	 */
	@ApiOperation(value = "管理员登出" ,  notes="管理员登出")
	@RequestMapping(value="/adminUserLoginOut", method = RequestMethod.GET)
	@ResponseBody
	public ResultVO<AdminUser> adminUserLoginOut(){
		String token = new TokenUtil().getToken();
		redisUtil.del(token);
		return new ResultVO<AdminUser>("001","登出成功");
	}

}
