package com.github.jakub098.ticketapp.service.impl;

import com.github.jakub098.ticketapp.model.Place;
import com.github.jakub098.ticketapp.model.dto.PlaceDto;
import com.github.jakub098.ticketapp.repository.PlaceRepository;
import com.github.jakub098.ticketapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> list() {
        return placeRepository.findAll();
    }

    @Override
    public Place getById(Integer placeId) {
        return placeRepository.getPlace(placeId);
    }

    @Override
    public void createPlace(PlaceDto place) {
        placeRepository.addPlace(place);
    }

    @Override
    public void updatePlace(Place place) {
        placeRepository.updatePlace(place);
    }

    @Override
    public void deletePlace(Integer placeId) {
        placeRepository.deletePlace(placeId);
    }
}
