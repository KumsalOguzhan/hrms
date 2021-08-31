package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/findbystatustrue")
    public DataResult<List<JobAdvertisement>> findByStatusTrue(){
        return this.jobAdvertisementService.findByStatusTrue();
    }

    @GetMapping("/findbystatustrueorderbycreatedate")
    public DataResult<List<JobAdvertisement>> findByStatusTrueOrderByCreateDate(){
        return this.jobAdvertisementService.findByStatusTrueOrderByCreateDate();
    }

    @PutMapping("/setjobadvertisementstatusfalse/{id}")
    public Result setJobAdvertisementStatusFalse(@PathVariable int id){
        return this.jobAdvertisementService.setJobAdvertisementStatusFalse(id);
    }
}
