package co.copper.testtask.repository;

import co.copper.testtask.model.Asset;
import org.springframework.data.repository.CrudRepository;

//@Slf4j
public interface AssetRepository extends CrudRepository<Asset, Long> {
}
