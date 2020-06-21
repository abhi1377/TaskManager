package org.example.taskmanagerdashboard.service;


import org.example.taskmanagerdashboard.model.SocialTask;
import org.example.taskmanagerdashboard.repo.SocialTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service("socialTaskService")
@EnableTransactionManagement
@EnableAutoConfiguration
public class SocialTaskServiceImpl  implements SocialTaskService{
    private SocialTaskRepository socialTaskRepository;
@Autowired
    public SocialTaskServiceImpl(SocialTaskRepository socialTaskRepository) {
        this.socialTaskRepository = socialTaskRepository;
    }

    @Override
    @Transactional
    public Iterable<SocialTask> findAllSocialTasks() {
        return socialTaskRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<SocialTask> findSocialTaskById(int Id) {
        return socialTaskRepository.findById(Id);
    }

    @Override
    public SocialTask createAndUpdateSocialTask(SocialTask socialTask) {
        return socialTaskRepository.save(socialTask);
    }

    @Override
    public void deleteSocialTask(SocialTask socialTask) {
socialTaskRepository.delete(socialTask);
    }

    @Override
    public void deleteSocialTaskById(int Id) {
socialTaskRepository.deleteById(Id);
    }
}
