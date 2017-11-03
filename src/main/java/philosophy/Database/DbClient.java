package philosophy.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.ListIterator;


@Component
public class DbClient {

    private Repository repository;

    @Autowired
    public DbClient(Repository repository) {
        this.repository = repository;
        this.repository.deleteAll();
    }

    public void insertDoc(String page, ArrayList<String> path, boolean found, boolean loop) {
        repository.save(new DbEntry(page, path, path.size(), found, loop));
    }

    public DbEntry getDoc(String page) {
        return repository.findByPage(page);
    }

    public void insertPath(ArrayList<String> path, boolean found, boolean loop) {
        ListIterator iterator = path.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
            insertDoc(path.get(0), path, found, loop);
            iterator.remove();


        }
//        for(String page: path) {
//            insertDoc(page,  path.subList(path.indexOf(page), path.size() -1), found, loop);
//        }

    }
}
