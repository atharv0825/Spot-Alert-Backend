package com.spotAlert.backend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HazardRouteMatch {
    private boolean onRoute;
    private int routeIndex;
    private double distance;
}
