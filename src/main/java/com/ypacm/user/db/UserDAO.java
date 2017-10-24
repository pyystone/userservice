package com.ypacm.user.db;

import com.ypacm.user.model.User;

public interface UserDAO {

//    @SQL("select * from test limit 1")
    public User getUser();
}
