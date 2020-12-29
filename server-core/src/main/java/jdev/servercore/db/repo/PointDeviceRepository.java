package jdev.servercore.db.repo;


import jdev.servercore.db.PointDevice;
import org.springframework.data.repository.CrudRepository;

// Репозиторий для таблицы PointDevice
public interface PointDeviceRepository extends CrudRepository<PointDevice, Integer>{
}
