package com.ypacm.user.data.repository;

import com.ypacm.user.data.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {

}
