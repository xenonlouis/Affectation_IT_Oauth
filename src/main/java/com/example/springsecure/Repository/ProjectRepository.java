package com.example.springsecure.Repository;

import com.example.springsecure.Model.Project;
import com.example.springsecure.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
