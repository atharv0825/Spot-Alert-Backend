package com.spotAlert.backend.Service;

import com.spotAlert.backend.DTO.HazardsDTO;
import com.spotAlert.backend.Entity.Hazard;
import com.spotAlert.backend.Mapper.HazardsMapper;
import com.spotAlert.backend.Repository.HazardRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class HazardService {

    private final HazardRepository hazardRepository;


    public List<Hazard> getAll() {
        return hazardRepository.findAll();
    }

    public HazardsDTO addHazards(HazardsDTO hazardsDTO , String source){
        try{
            Hazard hazard = HazardsMapper.toEntity(hazardsDTO, source);
            if(source.equalsIgnoreCase("USER-REPORT")){
                hazardsDTO.setSource("USER-REPORT");
            }
            else{
                hazardsDTO.setSource("ADMIN");
            }
            Hazard saved = hazardRepository.save(hazard);
            return HazardsMapper.toDTO(saved);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add hazard", e);
        }
    }

    public List<Hazard> findNearby(double latitude, double longitude, double radiusMeters) {

        try {
            Point userPoint = new Point(longitude, latitude);
            Distance radius = new Distance(radiusMeters / 1000.0, Metrics.KILOMETERS);

            log.info("MongoDB Query → findByLocationNear(point={}, radius(KM)={})",
                    userPoint, radius.getValue());

            List<Hazard> result = hazardRepository.findByLocationNear(userPoint, radius);

            log.info("MongoDB returned {} hazards within {} meters.", result.size(), radiusMeters);

            return result;

        } catch (Exception e) {
            log.error("Error occurred during geospatial query:", e);

            if (e.getMessage().contains("NoQueryExecutionPlans")) {
                log.error("MongoDB cannot execute geospatial query — likely missing or invalid 2dsphere index.");
            }
            if (e.getMessage().contains("geoNear")) {
                log.error("GeoNear error — check if all documents have valid GeoJSON {type:'Point'} structure.");
            }

            throw new RuntimeException("Failed to retrieve nearby hazards", e);
        }
    }
}
