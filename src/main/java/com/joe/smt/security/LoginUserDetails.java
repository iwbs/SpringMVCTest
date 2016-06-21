package com.joe.smt.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.joe.smt.entity.Users;

public class LoginUserDetails extends Users implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4056227653306332413L;
	private Set<String> authorities;

	public LoginUserDetails(Users user, Set<String> authorities) {
		super(user.getUsername(), user.getPassword(), user.getDisplayname(), user.getCreatedate(), user.getUpdatedate(), user.isEnabled());
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
