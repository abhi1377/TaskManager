package org.example.taskmanagerdashboard.repo;

import org.example.taskmanagerdashboard.model.SocialTask;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableAutoConfiguration
@EnableTransactionManagement
public interface SocialTaskRepository extends CrudRepository<SocialTask,Integer> {
}
