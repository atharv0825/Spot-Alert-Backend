package com.spotAlert.backend.Utilities.OSRM;

import com.spotAlert.backend.DTO.HazardRouteMatch;
import com.spotAlert.backend.DTO.RoutePoint;
import com.spotAlert.backend.Entity.Hazard;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class HazardousOnRoute {
    public static HazardRouteMatch matchHazardToRoute(
            Hazard hazard,
            List<RoutePoint> route,
            double thresholdMeters
    ) {
        double minDistance = Double.MAX_VALUE;
        int closestIndex = -1;

        for (int i = 0; i < route.size() - 1; i++) {

            RoutePoint a = route.get(i);
            RoutePoint b = route.get(i + 1);

            double distance = PointToSegmentDistanceUtil.distanceMeters(
                    a, b,
                    hazard.getLatitude(),
                    hazard.getLongitude()
            );

            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }

        if (minDistance <= thresholdMeters) {
            return new HazardRouteMatch(true, closestIndex, minDistance);
        }

        return new HazardRouteMatch(false, -1, minDistance);
    }

    public static int findUserRouteIndex(
            double userLat,
            double userLng,
            List<RoutePoint> route
    ) {
        double minDistance = Double.MAX_VALUE;
        int closestIndex = 0;

        for (int i = 0; i < route.size() - 1; i++) {

            RoutePoint a = route.get(i);
            RoutePoint b = route.get(i + 1);

            double distance = PointToSegmentDistanceUtil.distanceMeters(
                    a, b,
                    userLat,
                    userLng
            );

            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }
        return closestIndex;
    }



}
