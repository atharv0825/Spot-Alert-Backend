package com.spotAlert.backend.Repository;

import com.spotAlert.backend.Entity.Hazard;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HazardRepository extends MongoRepository<Hazard, String> {
    List<Hazard> findByLocationNear(Point location, Distance distance);
}
