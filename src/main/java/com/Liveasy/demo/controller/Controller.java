package com.Liveasy.demo.controller;

import com.Liveasy.demo.model.Loads;
import com.Liveasy.demo.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired LoadService loadService;

    @PostMapping("/load")
    public String addLoad(@RequestBody Loads loads) {
        loadService.addLoad(loads);
        return "Load details added successfully";
    }

    @GetMapping("/load")
    public ResponseEntity<List<Loads>> getLoadsByShipper(@RequestParam String shipperId) {
        List<Loads> loads = null;
        HttpStatus status;

        try{
            loads = loadService.getLoadByShipperId(shipperId);

            if(loads.isEmpty()){
                status = HttpStatus.NO_CONTENT;
            }else{
                status = HttpStatus.OK;
            }
        }catch (Exception e){
            System.out.println("The shipper ID is not valid");
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<List<Loads>>(loads,status);
    }

    @GetMapping("/load/{loadId}")
    public Loads getLoadById(@PathVariable Integer loadId) {
            Loads loads = null;
            HttpStatus status;

            try{
                loads = loadService.getLoadByLoadId(loadId);

                if(loads==null){
                    status = HttpStatus.NO_CONTENT;
                }else{
                    status = HttpStatus.OK;
                }
            }catch (Exception e){
                System.out.println("The Load ID is not valid");
                status = HttpStatus.BAD_REQUEST;
            }

            return loads;
        }


    @PutMapping("/load/{loadId}")
    public String updateLoad(@PathVariable Integer loadId, @RequestBody Loads updatedLoads) {
        return loadService.updatedLoad(loadId, updatedLoads);
    }

    @DeleteMapping("/load/{loadId}")
    public String deleteLoad(@PathVariable Integer loadId) {
       return loadService.deleteById(loadId);

    }
}
