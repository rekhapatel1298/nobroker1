package com.nobroker.service.impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.entity.OwnerPlans;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.repository.OwnerPlansRepo;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {
    private OwnerPlanRepository ownerPlanRepository;
    private OwnerPlansRepo ownerPlansRepository;

    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository, OwnerPlansRepo ownerPlansRepository, ModelMapper modelMapper) {
        this.ownerPlanRepository = ownerPlanRepository;
        this.ownerPlansRepository = ownerPlansRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerPlanDto createOwnerPlan(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan=mapToEntity(ownerPlanDto);

        OwnerPlan saveOwnerPlan=ownerPlanRepository.save(ownerPlan);
        return mapToDto(saveOwnerPlan);

    }

    @Override
    public List<OwnerPlanDto> getAllOwnarPlans() {
        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
        List<OwnerPlanDto> ownerPlanDtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());

        return ownerPlanDtos;
    }

    @Override
    public OwnerPlans subscribePlan(long userId, int duration) {
        OwnerPlans ownerPlan=new OwnerPlans();
        ownerPlan.setUserId(userId);
        ownerPlan.setSubscriptionActive(true);
        ownerPlan.setSubscriptionActiveDate(LocalDate.now());
        ownerPlan.setSubscriptionExpirationDate(LocalDate.now().plusDays(duration));
        ownerPlan.setNumberOfDays(duration);
        return ownerPlansRepository.save(ownerPlan);

    }

    @Override
    public boolean checkExpiration(long planId) {
        return false;
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return ownerPlan;


    }
    OwnerPlanDto mapToDto(OwnerPlan ownerPlan) {
        OwnerPlanDto ownerPlanDto= modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return ownerPlanDto;
    }
    }
