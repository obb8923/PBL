package team2.PBL_AD_Manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team2.PBL_AD_Manager.domain.User;
import team2.PBL_AD_Manager.repository.UserRePository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRePository userRePository;

    public User findOne(Long id){
        return userRePository.fincOne(id);
    }

    @Transactional
    public void save(User user) {
        userRePository.save(user);
    }

}
