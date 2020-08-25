package com.nuist.hospitalcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuist.hospitalcare.entity.Emergency;

public interface EmergencyRepository extends JpaRepository<Emergency, Integer> {

}
