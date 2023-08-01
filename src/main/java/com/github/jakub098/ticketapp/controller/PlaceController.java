package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.Place;
import com.github.jakub098.ticketapp.model.dto.PlaceDto;
import com.github.jakub098.ticketapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController {
    
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> list() {
        return placeService.list();
    }

    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public Place getById(@RequestParam Integer placeId) {
        return placeService.getById(placeId);
    }

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public void addPlaceAddress(@RequestBody PlaceDto place) {
        placeService.createPlace(place);
    }

    @RequestMapping(value = "/place", method = RequestMethod.DELETE)
    public void deletePlaceAddress(@RequestParam Integer placeId) {
        placeService.deletePlace(placeId);
    }

    @RequestMapping(value = "/place", method = RequestMethod.PUT)
    public void updatePlaceAddress(@RequestBody Place place) {
        placeService.updatePlace(place);
    }
}
