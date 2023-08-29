package com.Liveasy.demo.service;

import com.Liveasy.demo.model.Loads;
import com.Liveasy.demo.repo.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadService {

    @Autowired
    LoadRepo loadRepo;
    public void addLoad(Loads loads) {
        loadRepo.save(loads);
    }

    public List<Loads> getLoadByShipperId(String shipperId) {
        return loadRepo.findByShipperId(shipperId);
    }

    public Loads getLoadByLoadId(Integer loadId) {
        return loadRepo.findById(loadId).orElse(null);
    }
    public String updatedLoad(Integer loadId, Loads updatedLoads) {
        Loads loads = null;

        loads = loadRepo.getLoadByLoadId(loadId);

        if (loads == null) {
            return "The Load ID is not valid";
        } else {
            loads.setLoadingPoint(updatedLoads.getLoadingPoint());
            loads.setDate(updatedLoads.getDate());
            loads.setComment(updatedLoads.getComment());
            loads.setWeight(updatedLoads.getWeight());
            loads.setNoOfTrucks(updatedLoads.getNoOfTrucks());
            loads.setProductType(updatedLoads.getProductType());
            loads.setShipperId(updatedLoads.getShipperId());
            loads.setTruckType(updatedLoads.getTruckType());
            loads.setUnloadingPoint(updatedLoads.getUnloadingPoint());
        }
        return "Load details updated successfully";
    }

    public String deleteById(int loadId) {
        loadRepo.deleteById(loadId);
        return "Load deleted successfully";
    }
}
