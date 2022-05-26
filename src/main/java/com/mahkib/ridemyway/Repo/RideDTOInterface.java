package com.mahkib.ridemyway.Repo;

import com.mahkib.ridemyway.constants.RideStatus;
import com.mahkib.ridemyway.constants.RideType;
import com.mahkib.ridemyway.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface RideDTOInterface extends JpaRepository<RideOffers, Long> {

    @Query(value = "SELECT r FROM Rides r WHERE r.id = r.id")
    void findRideById(Long id);

    @Query(value = "SELECT r FROM Rides")
    Set<Rides> findAllRides();

    @Query(value = "CRE")
    void insertRides();

    @Query(value = "DELETE FROM Rides WHERE RideId = RideId")
    void delete();

    void saveRide(Rides ride);

    @Query(value = "SELECT r FROM Rides r WHERE r.rideType = rideType")
    Set<Rides> findRidesByRideType(RideType rideType);

    @Query(value = "SELECT r FROM Rides r WHERE r.rideStatus = rideStatus")
    Set<Rides> findRidesByRideStatus(RideStatus rideStatus);

    @Query(value = "SELECT r FROM Rides r WHERE r.user = user")
    Set<Rides> findRidesByUser(User user);

}



