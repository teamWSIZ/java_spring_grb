package wsi.repo;

import org.springframework.data.repository.CrudRepository;
import wsi.model.Pass;

public interface PassRepo extends CrudRepository<Pass,Integer> {
    Pass findByUser(String user);
}
