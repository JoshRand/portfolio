package com.joshrand.portfoliobackend.service;

import com.joshrand.portfoliobackend.dao.TileDao;
import com.joshrand.portfoliobackend.model.db.Tile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TileServiceImpl implements TileService{

    @Autowired
    TileDao tileDao;
    
    @Override
    public Tile saveTile(Tile tile) {
       return tileDao.saveTile(tile);
    }
    
}