package com.Liveasy.demo.repo;

import com.Liveasy.demo.model.Loads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepo extends JpaRepository<Loads,Integer> {
    Loads getLoadByLoadId(Integer loadId);

    List<Loads> findByShipperId(String shipperId);
}
