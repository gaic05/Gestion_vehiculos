package com.example.vehiculo.repository;
import com.example.vehiculo.model.MarcaVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MarcaVehiculoRepository extends JpaRepository<MarcaVehiculo, Long>  {
}
