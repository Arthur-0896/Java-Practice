package javaPractice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FileStreams {
	public static void main(String[] args) throws IOException {
		List<Movie> movies = new ArrayList<Movie>();

		File file = new File("MoviesList.txt");

		file.createNewFile();

		PrintWriter pw = new PrintWriter(file);

		pw.println("The Conjuring/Horror/Patrick Wilson");
		pw.println("The Fast & the Furious/Action/Paul Walker");
		pw.print("Harry Potter/Mystery/Daniel Radcliffe");

		pw.flush();
		pw.close();

		Path path = file.toPath();
		Stream<String> moviesStream = Files.lines(path);

		moviesStream.forEach(line -> {
			String[] movieArr = line.split("/");
			Movie movie = new Movie();
			movie.setName(movieArr[0]);
			movie.setGenre(Genre.valueOf(movieArr[1].toUpperCase()));
			movie.setActor(movieArr[2]);

			movies.add(movie);
		});

		moviesStream.close();

		for (Movie movie : movies) {
			System.out.println(movie);
		}

		DoubleStream doubleStream = DoubleStream.of(107.2, 108.8, 100.1, 102.3);
		System.out.println("DoubleStream count is: " + doubleStream.count());

	}
}

class Movie {

	private String name;
	private Genre genre;
	private String actor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + ", actor=" + actor + "]";
	}

}

enum Genre {
	ACTION, COMEDY, ROMANCE, HORROR, MYSTERY
}