package com.service.examen.service.impl;

import com.service.examen.model.Order;
import com.service.examen.repository.OrderRepository;
import com.service.examen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order guardarOrden(Order orden) {
        return orderRepository.save(orden);
    }

    @Override
    public Order buscarOrden(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
