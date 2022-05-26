package com.mahkib.ridemyway.controller;


import com.mahkib.ridemyway.services.RideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/rides")
public class RideController {

    private RideService rideService;

    @GetMapping("/Rides")
    public void getRides() {
      rideService.getAllRides();
    }

    @GetMapping("/rides/<rideId>")
    public void getRideById() {
        rideService.getRideById();
    }

    @PostMapping("/rides")
    public void CreateRideOffer() {
        rideService.createRide();
    }

    @PostMapping("/rides/<rideId>")
    public void RequestRide() {
        rideService.requestRide();
    }


}
