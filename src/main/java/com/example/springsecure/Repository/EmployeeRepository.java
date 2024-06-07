package com.example.springsecure.Repository;

import com.example.springsecure.Model.Employee;
import com.example.springsecure.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   // Optional<User> findByMail(String mail);
}
