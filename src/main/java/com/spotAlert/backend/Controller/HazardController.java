package com.spotAlert.backend.Controller;

import com.spotAlert.backend.DTO.HazardsDTO;
import com.spotAlert.backend.Entity.Hazard;
import com.spotAlert.backend.Repository.HazardRepository;
import com.spotAlert.backend.Service.HazardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hazards")
public class HazardController {
    private final HazardService hazardService;

    public HazardController(HazardService hazardService) {
        this.hazardService = hazardService;
    }

    @PostMapping("/admin/add")
    public ResponseEntity<HazardsDTO> addByAdmin(@RequestBody HazardsDTO dto) {
        HazardsDTO result = hazardService.addHazards(dto, "ADMIN");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/user/add")
    public ResponseEntity<HazardsDTO> addByUser(@RequestBody HazardsDTO dto) {
        HazardsDTO result = hazardService.addHazards(dto, "USER-REPORT");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<Hazard>> getNearby(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "500") double radius
    ) {
        List<Hazard> hazards = hazardService.findNearby(lat, lng, radius);
        return ResponseEntity.ok(hazards);
    }


}
