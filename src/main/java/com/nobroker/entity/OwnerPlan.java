package com.nobroker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner_plans")
public class OwnerPlan {
    @Id
    private long planId;
    @Column(name ="plan_name,unique=true")
    private String planName;
    @Column(name = "price")
    private double price;
    @Column(name ="plan_validity")
    private  int planValidity;
    @Column(name = "property_promotion")
    private boolean relationshipManager;
    @Column(name = "rental_agreement")
    private boolean rentalAgreement;
    @Column(name = "property_promotion")
    private boolean propertyPromotion;
    @Column(name = "gauranteed_tenants")
    private  boolean gauranteedTenants;
    @Column(name = "showing_property")
    private boolean showingProperty;
    @Column(name = "facebook_marketing_of-property")
    private boolean facebookMarketingOfProperty;
}

