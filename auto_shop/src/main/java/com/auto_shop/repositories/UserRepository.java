package com.auto_shop.repositories;

import com.auto_shop.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u FROM User AS u WHERE u.phone=:phone")
    User getByPhone(@Param("phone") String phone);
}
