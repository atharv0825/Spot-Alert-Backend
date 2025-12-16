package com.spotAlert.backend.Controller;

import com.spotAlert.backend.DTO.RouteRequest;
import com.spotAlert.backend.DTO.RouteResponse;
import com.spotAlert.backend.Service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping("/optimal")
    public ResponseEntity<RouteResponse> getBasicRoute(
            @Valid @RequestBody RouteRequest request
    ) {

        RouteResponse response = routeService.getBasicRoute(request);
        return ResponseEntity.ok(response);
    }


}
