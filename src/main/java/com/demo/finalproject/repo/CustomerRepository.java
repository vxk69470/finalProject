package com.demo.finalproject.repo;

import java.util.List;

import com.demo.finalproject.domain.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Modifying
    @Query("update Customer u set u.firstName = :first_name, u.lastName =:last_name where u.id = :id")
    void updatePhone(@Param(value = "id") long id, @Param(value = "first_name") String fistName, @Param(value = "last_name") String lastName );

}
