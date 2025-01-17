package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.DietPlanDto;

public interface IDietPlanService {

    /**
     * Cria um novo paciente.
     *
     * @param dietPlanDto - DietPlanDto contendo os dados do paciente a ser criado.
     * @return DietPlanDto - DTO da dieta criada, incluindo o ID gerado.
     */
    void createDietPlan(DietPlanDto dietPlanDto);

}
