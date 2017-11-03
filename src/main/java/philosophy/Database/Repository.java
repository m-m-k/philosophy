package philosophy.Database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<DbEntry,String> {
    DbEntry findByPage(String page);
}
