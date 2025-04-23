package com.gemas.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gemas.Curso.entities.OrderItem;
import com.gemas.Curso.entities.pk.OrderItemPk;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{
	
}
