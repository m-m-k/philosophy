package philosophy.Database;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class DbConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "dataBaseName";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("mongo", 27017);
    }
}
