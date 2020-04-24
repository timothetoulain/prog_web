package MyBookClub.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
public class BookService {

	private List<Book> books = new ArrayList<Book>();
	private List<Reader> readers= new ArrayList<Reader>();


	@Autowired
	BookRepository bookRepository;

	@Autowired
	ReaderRepository readerRepository;


	public BookService(){}

	/********************************** Reader part ******************************************************/
	@CrossOrigin
	@RequestMapping(value = "/readers", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String addReader(@RequestBody Reader reader) throws Exception{
		readers.add(reader);
		readerRepository.save(reader);
		return reader.getName()+" added successfully";

		
	}
	@CrossOrigin
	@RequestMapping(value = "/readers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Reader> getAllReader(){
		return readerRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/readers/{name}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteReader(@PathVariable(value = "name") String name){
		Reader r=readerRepository.findByName(name);
		if(!r.equals(null)) {
			readerRepository.delete(r);
			for(int i=0;i<readers.size();i++) {
				if(readers.get(i).getName().equals(name)) {
					readers.remove(i);
					break;
				}	
			}
		}
		return "Reader deleted successfully";

	}

	/********************************** Book part ******************************************************/
	@CrossOrigin
	@RequestMapping(value="/books", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Book> getListOfBooks(){
		return bookRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String addBook(@RequestBody Book book) throws Exception{
			books.add(book);
			bookRepository.save(book);
			return book.getTitle()+" successfully added";
		}

	@CrossOrigin
	@RequestMapping(value = "/books/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteBook(@PathVariable(value = "title") String title){
		Book b=bookRepository.findByTitle(title);
		if(!b.equals(null)) {
			bookRepository.delete(b);
			for(int i=0;i<books.size();i++) {
				if(books.get(i).getTitle().equals(title)) {
					books.remove(i);
					break;
				}	
			}
		}
		return "Book deleted successfully";
	}

}