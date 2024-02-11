package com.nobroker.service;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.entity.OwnerPlans;
import com.nobroker.payload.OwnerPlanDto;

import java.util.List;

public interface OwnerPlanService {



    public OwnerPlanDto createOwnerPlan(OwnerPlanDto ownerPlanDto) ;


    List<OwnerPlanDto> getAllOwnarPlans();

    OwnerPlans subscribePlan(long userId, int duration);

    boolean checkExpiration(long planId);
}
