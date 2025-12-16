package com.spotAlert.backend.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private double distanceMeters;
    private double durationSeconds;
    private String polyline;
    private int totalHazardsCount;
    private List<HazardRouteMatch> allHazardsOnRoute;
}
