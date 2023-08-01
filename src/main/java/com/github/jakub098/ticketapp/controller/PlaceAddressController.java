package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.PlaceAddress;
import com.github.jakub098.ticketapp.model.dto.PlaceAddressDto;
import com.github.jakub098.ticketapp.service.PlaceAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceAddressController {

    @Autowired
    private PlaceAddressService placeAddressService;

    @RequestMapping(value = "/place-addresses", method = RequestMethod.GET)
    public List<PlaceAddress> list() {
        return placeAddressService.list();
    }

    @RequestMapping(value = "/place-address", method = RequestMethod.GET)
    public PlaceAddress getById(@RequestParam Integer placeAddressId) {
        return placeAddressService.getById(placeAddressId);
    }

    @RequestMapping(value = "/place-address", method = RequestMethod.POST)
    public void addPlaceAddress(@RequestBody PlaceAddressDto placeAddress) {
        placeAddressService.createPlaceAddress(placeAddress);
    }

    @RequestMapping(value = "/place-address", method = RequestMethod.DELETE)
    public void deletePlaceAddress(@RequestParam Integer placeAddressId) {
        placeAddressService.deletePlaceAddress(placeAddressId);
    }

    @RequestMapping(value = "/place-address", method = RequestMethod.PUT)
    public void updatePlaceAddress(@RequestBody PlaceAddress placeAddress) {
        placeAddressService.updatePlaceAddress(placeAddress);
    }


}
