package com.example.crud.Repositories;

import com.example.crud.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, long> {

}