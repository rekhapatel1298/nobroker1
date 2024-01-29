package com.nobroker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class OwnerPlan {
    @Id
    private long planId;
    @Column(name ="plan_name,unique=true")
    private String planName;
    @Column(name = "price")
    private double price;
    @Column(name ="plan_validity")
    private  int planValidity;
    @Column(name = "rental_agreement")
    private boolean rentalAgreement;
    @Column(name = "property_promotion")
    private boolean propertyPromotion;
    @Column(name = "guaranteed_tenants")
    private  boolean guaranteedTenants;
    @Column(name = "showing_property")
    private boolean showingProperty;
    @Column(name = "facebook_marketing_of-property")
    private boolean facebookMarketingOfProperty;
}

