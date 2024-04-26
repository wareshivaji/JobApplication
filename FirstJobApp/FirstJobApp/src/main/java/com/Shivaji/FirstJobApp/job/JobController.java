package com.Shivaji.FirstJobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

//    @GetMapping("/jobs")
//    public List<Job> findAll(){
//        return jobService.findAll();
//    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job addded Successfully", HttpStatus.OK);
    }

//    @PostMapping("/jobs")
//
//    public String createJob(@RequestBody Job job){
//        jobService.createJob(job);
//        return "Job addded Successfully";
//    }

//    to get the better controlof the code
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
//        setting up dummy response
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/jobs/{id}")
//    public Job getJobById(@PathVariable Long id){
//        Job job = jobService.getJobById(id);
////        setting up dummy response
//        if(job != null)
//            return job;
//            return new Job(1L, "Testjob", "TestJob", "2000", "20000", "loc");
//    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob (@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to delete the job", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
//    instead of the mapping method used above we can use the below method also
//    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("not updated Successsfully", HttpStatus.NOT_FOUND);
    }
}

/*
GET /jobs: get all jobs
GET /jobs{id} :get specific jobs by id
POST /jobs: Create a new job(request body should contain the job details)
DELETE /jobs/{id}: delete a specific job by id
PUT /jobs/{id}: update a specific job by id(request body should contain the updates job)

Example API URL:
GET{base_url}/jobs
GET{base_url}/jobs/1
POST{base_url}/jobs
DELETE{base_url}/jobs/1
PUT {base_url}/jobs/1
 */
