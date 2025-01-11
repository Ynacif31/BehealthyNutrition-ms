package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.DietPlanDto;
import com.ygornacif.patient_api.entities.DietPlan;

public class DietPlanMapper {

    public static DietPlanDto mapToDto(DietPlan dietPlan, DietPlanDto dietPlanDto) {
        if (dietPlan == null) {
            return null;
        }
        dietPlanDto.setPatient(dietPlan.getPatient());
        dietPlanDto.setPlanDetails(dietPlan.getPlanDetails());
        return dietPlanDto;
    }

    public static DietPlan mapToEntity(DietPlanDto dietPlanDto, DietPlan dietPlan) {
        if (dietPlanDto == null) {
            return null;
        }
        dietPlan.setPatient(dietPlanDto.getPatient());
        dietPlan.setPlanDetails(dietPlanDto.getPlanDetails());
        return dietPlan;
    }
}
