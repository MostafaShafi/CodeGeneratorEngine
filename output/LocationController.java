package com.example.shesh.Controllers;

import com.example.shesh.Models.Location;
import com.example.shesh.Services.LocationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LocationController {

    @Autowired
    LocationService service;
    @Autowired
    private Gson gson;

    @PostMapping("/addlocation")
    public Location addLocation(@Valid @RequestBody Location location, BindingResult result) {
        return service.setLocation(location);
    }

    @PutMapping("/editlocation/{id}")
    public Location updateLocation(@PathVariable(value = "id") Long id, @Valid @RequestBody Location location) {
        return service.updateLocation(location);
    }

    @GetMapping("/location/{id}")
    public String getLocation(@PathVariable(value = "id") Long id) {
        return gson.toJson(service.getLocationById(id));
    }

    @GetMapping("/locations")
    public String getLocations() {
        return gson.toJsonTree(service.getLocations()).toString();
    }

    @DeleteMapping("/deletelocation/{id}")
    public void deleteLocation(@PathVariable(value = "id") Long id) {
        service.deleteLocationById(id);
    }

    @DeleteMapping("/deletelocation")
    public void deleteLocation(@Valid @RequestBody Location location) {
        service.deleteLocation(location);
    }

    @DeleteMapping("/deletealllocations")
    public void deleteAllLocations() {
        service.deleteAllLocations();
    }
}
