package org.example.taskmanagerdashboard;

import org.example.taskmanagerdashboard.model.HomeTask;
import org.example.taskmanagerdashboard.model.OfficeTask;
import org.example.taskmanagerdashboard.model.SocialTask;
import org.example.taskmanagerdashboard.repo.HomeTaskRepository;
import org.example.taskmanagerdashboard.repo.OfficeTaskRepository;
import org.example.taskmanagerdashboard.repo.SocialTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class TaskManagerDashboardApplication implements CommandLineRunner {
    private OfficeTaskRepository officeTaskRepository;
    private HomeTaskRepository homeTaskRepository;
    private SocialTaskRepository socialTaskRepository;

    @Autowired
    public TaskManagerDashboardApplication(OfficeTaskRepository officeTaskRepository, HomeTaskRepository homeTaskRepository, SocialTaskRepository socialTaskRepository) {
        this.officeTaskRepository = officeTaskRepository;
        this.homeTaskRepository = homeTaskRepository;
        this.socialTaskRepository = socialTaskRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerDashboardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        officeTaskRepository.save(new OfficeTask(1,"Project Complition",10,"Finished","20-06-2020","21-06-2020","Green"));
        officeTaskRepository.save(new OfficeTask(2,"Mail Manager",9,"pending","15-06,2020","30-16-2020","yellow"));
        homeTaskRepository.save(new HomeTask(3,"Cooking",8,"complete","20-06-2020","21-06-20","Gary"));
        homeTaskRepository.save(new HomeTask(4,"Painting",6,"pending","10-06-2020","30-06-20","Orange"));
        socialTaskRepository.save(new SocialTask(5,"NGO",10,"Pending","20-06-2020","25-06-2020","Red"));
    }
}
