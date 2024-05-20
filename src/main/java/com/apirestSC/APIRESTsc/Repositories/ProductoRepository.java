package com.apirestSC.APIRESTsc.Repositories;

import com.apirestSC.APIRESTsc.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
