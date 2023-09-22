package com.DAO;

import java.util.List;

import com.entity.movie;

public interface MovieDAO {
	
	public boolean addmovies(movie m);
	
	public List<movie> getAllMovies();
	
	public movie getMovieById(int movie_id);
	
	public boolean updateEditMovies(movie m);
	
	public boolean deleteMovies(int movie_id);
	
	public movie getMovieByName(String mname);

}
