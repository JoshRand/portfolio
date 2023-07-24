package com.joshrand.portfoliobackend.repo;

import com.joshrand.portfoliobackend.model.db.Tile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Crud repo for Tiles (Not Really needed)
@Repository
public interface TileRepo extends CrudRepository<Tile, Integer>{
   
}
