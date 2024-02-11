package com.nobroker.scheduler;



import com.nobroker.entity.OwnerPlans;
import com.nobroker.repository.OwnerPlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ExpirationScheduler {

    @Autowired
    private OwnerPlansRepo plansRepo;

    // Scheduled task to check for expired subscriptions daily
    @Scheduled(cron = "0 0 0 * * *") // Runs every day at midnight
    public void checkExpiredSubscriptions() {
        List<OwnerPlans> activePlans = plansRepo.findBySubscriptionActiveTrueAndSubscriptionExpirationDateBefore(LocalDate.now());
        LocalDate today = LocalDate.now();

        for (OwnerPlans plan : activePlans) {
//            if (plan.getSubscriptionExpiryDate().isBefore(today)) {
                // Subscription has expired, update status to inactive
                plan.setSubscriptionActive(false);
                plansRepo.save(plan);
            }
        }
    }
//}

