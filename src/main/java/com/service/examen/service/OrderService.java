package com.service.examen.service;

import com.service.examen.model.Order;

public interface OrderService {

    public Order guardarOrden(Order orden);

    public Order buscarOrden(Long id);
}
