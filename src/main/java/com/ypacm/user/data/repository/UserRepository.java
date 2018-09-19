package com.ypacm.user.data.repository;


import com.ypacm.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Query("from User u where u.nickName=:nickName")
    User findUserEntity(@Param("nickName") String nickName);
}
