package team2.PBL_AD_Manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.User;
import team2.PBL_AD_Manager.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> findUsers(){
		return userRepository.findAll();
	}

}
