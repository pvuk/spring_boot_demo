package com.spring.transaction.security;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class TransUser extends User {

	@NotNull
	private Long enduserId;

	@NotNull
	private String userDisplayName;

	@NotNull
	private Long versionId;

	@NotNull
	private Long typeId;

	private Long departmentId;

	private String email;

	public TransUser(String userDisplayName, String password, Collection<? extends GrantedAuthority> authorities,
			String email) {
		super(userDisplayName, password, authorities);
		this.userDisplayName = userDisplayName;
		this.email = email;
	}

	public TransUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Long enduserId, String userDisplayName, Long versionId, Long typeId, Long departmentId, String email) {
		super(username, password, authorities);
		this.enduserId = enduserId;
		this.userDisplayName = userDisplayName;
		this.versionId = versionId;
		this.typeId = typeId;
		this.departmentId = departmentId;
		this.email = email;
	}

	public TransUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			Long enduserId, String userDisplayName, Long versionId, Long typeId, Long departmentId, String email) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.enduserId = enduserId;
		this.userDisplayName = userDisplayName;
		this.versionId = versionId;
		this.typeId = typeId;
		this.departmentId = departmentId;
		this.email = email;
	}

	public TransUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Long enduserId, String userDisplayName, Long versionId, Long departmentId) {
		super(username, password, authorities);
		this.enduserId = enduserId;
		this.userDisplayName = userDisplayName;
		this.versionId = versionId;
		this.departmentId = departmentId;
	}
}