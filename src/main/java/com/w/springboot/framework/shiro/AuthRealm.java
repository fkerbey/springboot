package com.w.springboot.framework.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.w.springboot.test.entity.Module;
import com.w.springboot.test.entity.Role;
import com.w.springboot.test.entity.User;
import com.w.springboot.test.service.IUserService;

public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取session中的用户
		User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
		List<String> permissions = new ArrayList<>();
		Set<Role> roles = user.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				Set<Module> modules = role.getModules();
				if (modules.size() > 0) {
					for (Module module : modules) {
						permissions.add(module.getMname());
					}
				}
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);// 将权限放入shiro中.
		return info;
	}

	// 认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		User user = userService.findUserByUserName(((UsernamePasswordToken) token).getUsername());
		// 放入shiro.调用CredentialsMatcher检验密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
	}

}
