package com.nobroker.controller;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.entity.OwnerPlans;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.service.OwnerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ownerPlan")

public class OwnerPlanController {

    @Autowired
    private OwnerPlanService ownerPlanService;
    @PostMapping
    public ResponseEntity<OwnerPlanDto>createOwnerPlan(@RequestBody OwnerPlanDto ownerPlanDto){

       OwnerPlanDto dto= ownerPlanService.createOwnerPlan(ownerPlanDto);

       return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping
    public List<OwnerPlanDto> getAllOwnarPlans(){
        List<OwnerPlanDto> allOwnarPlans= ownerPlanService.getAllOwnarPlans();
        return allOwnarPlans;
    }

    // http://localhost:8080/api/ownerPlan/subscribe?userId=&duration=
    @PostMapping("/subscribe")
    public OwnerPlans subscribePlan(@RequestParam("userId") long userId, @RequestParam("duration") int duration) {
        return ownerPlanService.subscribePlan(userId, duration);
    }

    @GetMapping("/check-expiration/{planId}")
    public boolean checkExpiration(@PathVariable("planId") long planId) {
        return ownerPlanService.checkExpiration(planId);
    }
}
