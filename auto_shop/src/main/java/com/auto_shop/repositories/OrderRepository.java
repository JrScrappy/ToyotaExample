package com.auto_shop.repositories;

import com.auto_shop.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value = "SELECT o from Order AS o WHERE o.client.id=:id")
    List<Order> getByClientId(@Param("id") String id);

    @Query(value = "SELECT o FROM Order AS o WHERE o.endDateManager IS NULL AND o.canceled=false")
    List<Order> getForManager();
}
