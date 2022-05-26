package com.mahkib.ridemyway.services;


import com.mahkib.ridemyway.Repo.RideDTOInterface;
import com.mahkib.ridemyway.constants.RideStatus;
import com.mahkib.ridemyway.constants.RideType;
import com.mahkib.ridemyway.constants.UserType;
import com.mahkib.ridemyway.models.Rides;
import com.mahkib.ridemyway.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.data.repository.util.ClassUtils.ifPresent;


@Service
public class RideService implements RideInterface {

    private final RideDTOInterface rideDTO;


    private final Rides rides;
    private final User user;
    private final UserService userService;

    public RideService(User user, UserService userService, RideDTOInterface rideDTO, Rides rides, User user) {
        this.rideDTO = rideDTO;
        this.rides = rides;
        this.user = user;
        this.userService = userService;


    }


    @Override
    public void offerRides() {
        Set<Rides> rides = rideDTO.findAllRides();
        Map<RideType, List<Rides>> ridesByType = rides.stream().collect(Collectors.groupingBy(Rides::getRideType));
        ifPresent(ridesByType.get(RideType.OFFER));
        () -> ifPresent(ridesByType.get(RideType.REQUEST))
                .filter(ride -> ride.getRideStatus() == RideStatus.PENDING)
                .forEach(ride -> {
                    ride.setRideStatus(RideStatus.ACCEPTED);
                    rideDTO.save(ride);
                });
    }


    @Override
    public void requestRides() {


    }

    @Override
    public void cancelRides() {
        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType() == UserType.PASSENGER)
                .forEach(user -> {
                    Rides rideOffers = new Rides();
                    rideOffers.setRideType(RideType.OFFER);
                    rideOffers.setRideStatus(RideStatus.CANCELLED);
                    rideOffers.setUser((User) user.getUserType());
                    rideDTO.delete(rideOffers);
                });

    }

    @Override
    public void viewRides() {
        //Using Functional Programming, the Driver should be able to view all the rides
        //that he has offered and all the rides that he has requested.
        //The Driver should be able to cancel the ride that he has offered.
        //The Driver should be able to cancel the ride that he has requested.
        //The Driver should be able to accept the ride that he has requested.
        //The Driver should be able to complete the ride that he has accepted.
        //The Driver should be able to view the status of the ride that he has accepted.
        //The Driver should be able to view the status of the ride that he has completed.

        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType() == UserType.DRIVER)
                .forEach(user -> {
                    Rides rideOffers = new Rides();
                    rideOffers.setRideType(RideType.OFFER);
                    rideOffers.setRideStatus(RideStatus.OFFERED);
                    rideOffers.setUser((User) user.getUserType());
                });

    }


    public void getAllRides() {
        rideDTO.findAllRides();
    }

    public void getRideById() {
        rideDTO.findRideById((long) id);
    }

    public void createRide(Rides ride) {


    }


    public void deleteRide() {
        rideDTO.delete();
    }

    public void requestRide() {
        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType().equals(UserType.PASSENGER))
                .forEach(user -> {
                    Rides ride = new Rides();
                    ride.setRideStatus(RideStatus.REQUESTED);
                    ride.setRideType(RideType.POOL);
                    rideDTO.saveRide(ride);
                });

    }

    public void acceptRide() {
        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType().equals(UserType.DRIVER))
                .forEach(user -> {
                    Rides ride = new Rides();
                    ride.setRideStatus(RideStatus.ACCEPTED);
                    ride.setRideType(RideType.POOL);
                    rideDTO.saveRide(ride);
                });

    }

    public void completeRide() {
        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType().equals(UserType.PASSENGER))
                .forEach(user -> {
                    Rides ride = new Rides();
                    ride.setRideStatus(RideStatus.COMPLETED);
                    ride.setRideType(RideType.POOL);
                    rideDTO.saveRide(ride);
                });

    }

    public void viewRideStatus() {
        Optional<UserService> service = Optional.ofNullable(userService);
        service.stream()
                .filter(user -> user.getUserType().equals(UserType.DRIVER))
                .forEach(user -> {
                    Rides ride = new Rides();
                    ride.setRideStatus(RideStatus.ACCEPTED);
                    ride.setRideType(RideType.POOL);
                    rideDTO.saveRide(ride);
                });

    }

}

