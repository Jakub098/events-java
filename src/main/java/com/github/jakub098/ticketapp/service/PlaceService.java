package com.github.jakub098.ticketapp.service;

import com.github.jakub098.ticketapp.model.Place;
import com.github.jakub098.ticketapp.model.dto.PlaceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaceService {

    List<Place> list();
    Place getById(Integer placeId);
    void createPlace(PlaceDto place);
    void updatePlace(Place place);
    void deletePlace(Integer placeId);
}
