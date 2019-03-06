package slipmaster.com.vertx_exam;


import java.util.ArrayList;
import java.util.List;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import slipmaster.com.vertx_exam.entity.Movie;

public class App {

	
	
	public static void main(String[] args) {
		
		
		
		
		// List Of Movies
		
		List<Movie> movies = new ArrayList<>();

		Vertx vertx = Vertx.vertx();

		HttpServer httpServer = vertx.createHttpServer();

		Router router = Router.router(vertx);
	
	
	/**
	 * Creating A New Movie
	 * Adding Movie To The Array List
	 * 
	 * 
	 * 
	 */
		Route handler1 = router.post("/add").handler(BodyHandler.create()).handler(routingContext -> {
		    Movie movie = Json.decodeValue(routingContext.getBody(), Movie.class);
			HttpServerResponse serverResponse = routingContext.response();
			serverResponse.setChunked(true);
			movies.add(movie);
			serverResponse.end("Movie Added Successfully");
		});

		
		
		/**
		 * Getting List Of All 
		 * Exist Movies
		 * 
		 */
		Route handler2 = router.get("/get").produces("*/json").handler(routingContext -> {
			routingContext.response()
			.setChunked(true)
			.end(Json.encodePrettily(movies));
		});

		
		
		/**
		 * Getting Movie 
		 * By Movie Name
		 * Filter
		 * 
		 * 
		 */
		Route handler3 = router.get("/get/:name").produces("*/json").handler(routingContext -> {
			String name = routingContext.request().getParam("name");
			routingContext.response().setChunked(true).end(Json
					.encodePrettily(movies.stream()
							.filter(movie -> movie
									.getMovieName()
									.equals(name))
							        .findFirst()
							         .get()));
		});

		
		
		httpServer.requestHandler(router::accept).listen(8091);
	
	
	
}
}
