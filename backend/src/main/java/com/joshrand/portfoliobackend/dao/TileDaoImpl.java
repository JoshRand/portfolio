package com.joshrand.portfoliobackend.dao;

import com.joshrand.portfoliobackend.model.db.Tile;
import com.joshrand.portfoliobackend.repo.TileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TileDaoImpl implements TileDao{

    @Autowired
    TileRepo tileRepo;

    @Override
    public Tile saveTile(Tile tile) {
        return tileRepo.save(tile);
    }
    
}