package br.com.alura.forum.security.configuration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forum.model.User;
import br.com.alura.forum.repository.UserRepository;

@Service
public class UsersService implements UserDetailsService{

	@Autowired  
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> possibleUser = userRepository.findByEmail(userName);
	
		return possibleUser.orElseThrow(() -> new UsernameNotFoundException("Não Possivel encontrar usuario com email: " + userName));
	}

}
