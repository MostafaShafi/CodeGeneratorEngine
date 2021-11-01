package com.example.shesh.Services;

import com.example.shesh.Models.Location;
import com.example.shesh.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LocationService {

    @Autowired
    LocationRepository repository;

    public Location getLocationById(Long id) {
    return repository.findById(id.intValue()).get();
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> locationList = new ArrayList<>();
        repository.findAll().forEach(location -> locationList.add(location));
        return locationList;
    }

    public Location setLocation(Location location) {
        return repository.save(location);
    }

    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    public void deleteLocationById(Long id) {
        repository.deleteById(id.intValue());
    }

    public void deleteAllLocations() {
        repository.deleteAll();
    }

    public void deleteLocation(Location location) {
        repository.delete(location);
    }
}
