package com.mahkib.ridemyway.models;


import com.mahkib.ridemyway.constants.RideStatus;
import com.mahkib.ridemyway.constants.RideType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.Optional;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString

public class Rides {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private Long RideId;

    private RideType rideType;

    private RideStatus rideStatus;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private User passenger;

    private String location;

    private String destination;}




