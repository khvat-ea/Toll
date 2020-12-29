package jdev.servercore.db.repo;

import jdev.servercore.db.PointDevice;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<PointDevice, Integer>{
}
