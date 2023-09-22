package com.DAO;

import java.util.List;
import com.entity.show;

public interface ShowDAO {

	public boolean addshows(show s);

	public List<show> getAllshows();

	public show getShowById(int show_id);

	public boolean updateEditShows(show s);

	public boolean deleteShows(int show_id);

}
