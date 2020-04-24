package MyBookClub.demo;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> {

    public Book findByTitle(String title);

}
