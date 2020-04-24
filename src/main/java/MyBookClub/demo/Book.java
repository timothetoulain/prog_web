package MyBookClub.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

	@org.springframework.data.annotation.Id
	private String title;
	private String author;
	private String person; //person who first added it 
	
	public Book() {
		super();
	}
	
	public Book(String title, String author) {
		super();
		this.title= title;
		this.author = author;
		//this.person= person;
	}
	public Book(String title, String author,String person) {
		super();
		this.title= title;
		this.author = author;
		this.person= person;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}

}
