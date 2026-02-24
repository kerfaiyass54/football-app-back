package com.kerfaiyassine.supporter.controllers;


import com.kerfaiyassine.supporter.DTOs.LocationDTO;
import com.kerfaiyassine.supporter.entities.Location;
import com.kerfaiyassine.supporter.enums.Continent;
import com.kerfaiyassine.supporter.services.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService  locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/")
    public Location saveLocation(@RequestBody LocationDTO location) {
        Location location1 = locationService.saveLocation(location);
        return location1;
    }

    @GetMapping("/{locationName}")
    public LocationDTO getLocation(@PathVariable String locationName) {
        LocationDTO location = locationService.getLocation(locationName);
        return location;
    }

    @GetMapping("/")
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> locationDTOS = locationService.getLocations();
        return ResponseEntity.ok(locationDTOS);
    }

    @DeleteMapping("/{locationName}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String locationName) {
        locationService.deleteLocation(locationName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/supporters/{locationName}")
    public ResponseEntity<Integer> numberOfSupporters(@PathVariable String locationName) {
        Integer num = locationService.numberOfHabitants(locationName);
        return ResponseEntity.ok(num);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<LocationDTO>> getLocationsPage(@RequestParam int  page,@RequestParam int size){
        Page<LocationDTO> locationDTOS = locationService.getLocationsPage(page, size);
        return ResponseEntity.ok(locationDTOS);
    }

    @GetMapping("/continent/{continent}")
    public ResponseEntity<Page<LocationDTO>> getLocationsByContinent(@RequestParam int  page,@RequestParam int size,@PathVariable Continent continent){
        Page<LocationDTO> locationDTOS = locationService.getLocationsPageByContinent(page,size,continent);
        return ResponseEntity.ok(locationDTOS);
    }
}
