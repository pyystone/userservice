package com.ypacm.user.data.repository;


import com.ypacm.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Query("from User u where u.nickName=:nickName")
    User findUserEntity(@Param("nickName") String nickName);
}
