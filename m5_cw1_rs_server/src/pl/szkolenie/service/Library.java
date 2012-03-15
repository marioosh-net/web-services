package pl.szkolenie.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return book;
	}
	
	@GET
	public List<Book> getBooks() {
		return new ArrayList<Book>(books.values());
	}
	
	@POST
	public Response add(@FormParam("author") String author, @FormParam("title") String title) {
		Book book = new Book(title, author);
		book.setId(lastId.getAndIncrement());
		books.put(book.getId(), book);
		return Response.created(URI.create(""+book.getId())).build();
	}
	
	@Path("{id:\\d+}")
	@DELETE
	public Response remove(@PathParam("id") long id) {
		books.remove(id);
		return Response.ok().build();
	}
	
	@Path("update")
	// @PUT
	@POST
	public Response update(@FormParam("id") long id, @FormParam("author") String author, @FormParam("title") String title) {
		if(books.containsKey(id)) {
			Book book = books.get(id);
			book.setAuthor(author);
			book.setTitle(title);
			return Response.noContent().build();
		}
		return Response.status(Status.CREATED).build();
	}
	
	
}
