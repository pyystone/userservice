package com.ypacm.user.model.repository;

import com.ypacm.user.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public interface TokenRepository extends JpaRepository<Token,Long> {

}
