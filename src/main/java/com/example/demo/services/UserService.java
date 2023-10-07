package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) throws ResourceNotFoundException {		
		try {
			return userRepository.findById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Não foi possível encontrar user");
		}
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(User user) throws ResourceNotFoundException {
		try {
			userRepository.delete(user);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Não foi possível encontrar user para deletar");
		}
	}
	
	public User update(User newUser, Long id) throws ResourceNotFoundException {
		try {
			return userRepository.findById(id)
		      .map(user -> {
		    	  user.setNome(newUser.getNome());
		    	  user.setEmail(newUser.getEmail());
		    	  user.setPassword(newUser.getTelefone());
		    	  user.setTelefone(newUser.getTelefone());
		        return userRepository.save(user);
		      })
		      .orElseGet(() -> {
		    	newUser.setId(id);
		        return userRepository.save(newUser);
		      });
		} catch (Exception e) {
			throw new ResourceNotFoundException("Não foi possível encontrar user para atualizar");
		}
	}
}
