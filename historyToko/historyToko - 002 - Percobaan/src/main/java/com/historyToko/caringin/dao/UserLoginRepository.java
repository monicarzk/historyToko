package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.String;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

    // that's it . . . NO ANY CODE :-)

}
