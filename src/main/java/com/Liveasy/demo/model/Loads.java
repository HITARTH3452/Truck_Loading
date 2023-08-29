package com.Liveasy.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "load_id")
    private Integer loadId;

    @Column(name = "loading_point")
    private String loadingPoint;

    @Column(name = "unloading_point")
    private String unloadingPoint;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "truck_type")
    private String truckType;

    @Column(name = "no_of_trucks")
    private int noOfTrucks;

    @Column(name = "weight")
    private double weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "shipper_id")
    private String shipperId;

    @Column(name = "date")
    private Date date;
}
