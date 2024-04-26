package com.Shivaji.FirstJobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;
//can also use CrudRepository
public interface JobRepository extends JpaRepository<Job, Long> {
}
