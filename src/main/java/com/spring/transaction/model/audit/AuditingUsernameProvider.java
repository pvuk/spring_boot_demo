package com.spring.transaction.model.audit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.spring.transaction.exception.UserAuthenticationException;
import com.spring.transaction.model.Customer;
import com.spring.transaction.repository.CustomerRepo;
import com.spring.transaction.security.TransUser;

/**
 * Provides usernames to the {@link AuditListener}.
 * 
 * @author venkataudaykiranp
 *
 */
@Component
public class AuditingUsernameProvider implements AuditorAware<String> {
	
	@Autowired
    private CustomerRepo customerRepo;

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			throw new UserAuthenticationException("User Authentication is null");
		}
		
		if (!authentication.isAuthenticated()) {
			throw new UserAuthenticationException("User is not authenticated");
		}
		String username = null;
		Object principal = authentication.getPrincipal();
		if (TransUser.class.isAssignableFrom(principal.getClass())) {
			TransUser user = (TransUser) principal;
			username = user.getUserDisplayName();
			return Optional.of(username);
		} else if(UserDetails.class.isAssignableFrom(principal.getClass())) {
			UserDetails userDetails = 
					(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			username = userDetails.getUsername();
			if(username.contains("@")) {
				Customer userFromDatabase = null;
		        userFromDatabase = customerRepo.findByEmailCaseInsensitive(username);
		        if(userFromDatabase != null) {
		        	username = userFromDatabase.getLoginName().toLowerCase();
		        }
			}
			return Optional.of(username);
		} else {
			throw new UserAuthenticationException("Unknown principal type: " + principal.getClass());
		}
		
    }
	
	public String getCurrentAuditorAsString() {
		
		return getCurrentAuditor().orElse(null);
	}
}