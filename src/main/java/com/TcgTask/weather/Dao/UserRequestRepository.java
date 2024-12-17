package com.TcgTask.weather.Dao;

import org.springframework.data.repository.CrudRepository;

import com.TcgTask.weather.Model.UserRequest;

public interface UserRequestRepository extends CrudRepository<UserRequest, Long> {
    Iterable<UserRequest> findByUserName(String userName);
    Iterable<UserRequest> findByPostalCode(String postalCode);
}
