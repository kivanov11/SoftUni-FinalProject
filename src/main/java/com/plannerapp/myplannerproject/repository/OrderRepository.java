package com.plannerapp.myplannerproject.repository;

import com.plannerapp.myplannerproject.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
