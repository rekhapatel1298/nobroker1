package com.nobroker.repository;

import com.nobroker.entity.OwnerPlans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OwnerPlansRepo extends JpaRepository<OwnerPlans,Long> {
    List<OwnerPlans> findBySubscriptionExpirationDateBefore(LocalDate date);

    List<OwnerPlans> findBySubscriptionActiveTrueAndSubscriptionExpirationDateBefore(LocalDate date);
}
