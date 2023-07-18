package org.rina.config;

import java.util.Optional;

import org.rina.dao.IUserJpaDao;
import org.rina.model.SecurityUser;
import org.rina.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Retourne la liste des utilisateurs pour obtenir les "UserDetails" de
 * l'utilisateur connecté Nécessaire pour la configuration de la sécurité
 * 
 * @author Didier
 *
 */

@Service(value = "myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	private IUserJpaDao usersDAO;

	public MyUserDetailsService(IUserJpaDao usersDAO) {
		this.usersDAO = usersDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> oUser = usersDAO.findById(username);
		if (oUser.isPresent())
			return new SecurityUser(oUser.get());
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}

}
