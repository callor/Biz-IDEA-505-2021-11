package com.callor.sec.repository;

import com.callor.sec.models.UserDetailsVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao
        extends JpaRepository<UserDetailsVO, String> {

}
