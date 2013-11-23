package com.jmt.placard.dao;

import java.util.List;

import com.jmt.placard.po.Placard;

public interface PlacardDao {
	public boolean addPlacard(Placard placard);
	public boolean updatePlacard(Placard placard);
	public Placard getPlacard(int id);
	public boolean deletePlacard(int id);
	public List<Placard> getAllPlacard();
    public boolean isExsit(String placardTitle);
}
