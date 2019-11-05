package wsi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wsi.model.Komp;

@Repository
public interface KompRepo extends CrudRepository<Komp, String> {

}
