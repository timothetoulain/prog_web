package MyBookClub.demo;

import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<Reader,String> {

    public Reader findByName(String name);

}
