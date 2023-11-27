package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.WeatherData;

@Repository
public interface weatherRepository extends JpaRepository<WeatherData, Long> {

}
