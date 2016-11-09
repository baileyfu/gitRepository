package com.x.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new GrantedAuthorityImpl("ROLE_USER"));
		if(username.equals("admin")){
			roles.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		UserDetails u = new User(username, "", true, true, true, true, roles);
		System.out.println(username+"++++++++++++"+u.getAuthorities());
		return u;
	}

}
