package co.talento.uco.vehiculo.adaptador;


import co.talento.uco.vehiculo.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVehiculoJpa extends JpaRepository<EntidadVehiculo, String> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM VEHICULO WHERE VEHICULO.USUARIO_PERFIL_NOMBRE_USUARIO == :nombreUsuario")
    List<EntidadVehiculo> findAllByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

    void deleteByPlaca(String placa);
    EntidadVehiculo findByPlaca(String placa);
}
