package com.nobroker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owner_plans")
public class OwnerPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_plan_id")
    private Long ownerPlanId;

    @Column(name = "user_id",unique = true)
    private Long userId;
    private boolean subscriptionActive;
    private LocalDate subscriptionActiveDate;
    private LocalDate subscriptionExpirationDate;

    private int numberOfDays;

    // constructore ,getter and setters

}
