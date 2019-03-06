package slipmaster.com.vertx_exam.entity;

import java.util.Date;

public class Movie {

	
	private String movieName;
	
	private boolean adult;
	
	private Date date;
	
	private String playTime;

	public Movie() {
		super();
		
	}

	public Movie(String movieName, boolean adult, Date date, String playTime) {
		super();
		this.movieName = movieName;
		this.adult = adult;
		this.date = date;
		this.playTime = playTime;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", adult=" + adult + ", date=" + date + ", playTime=" + playTime + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
