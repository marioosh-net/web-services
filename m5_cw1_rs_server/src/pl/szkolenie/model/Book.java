package pl.szkolenie.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private long id;
	private String title;
	private String author;
	
	public Book() {
	}
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
}
