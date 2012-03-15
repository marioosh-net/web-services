package pl.szkolenie.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import pl.szkolenie.model.Book;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/library/books")
public class Library {
	private Map<Long, Book> books = new ConcurrentHashMap<Long, Book>();
	private AtomicLong lastId = new AtomicLong(1);
	
	public Library() {
		Book book = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz");
		book.setId(lastId.getAndIncrement());
		books.put(book.getId(), book);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id:\\d+}")
	@GET
	public Book getBook(@PathParam("id") long id) {
		Book book = books.get(id);
		if(book == null) {
			throw new WebApplicationException();
		}
		return book;
	}
}
