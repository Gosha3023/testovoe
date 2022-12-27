package org.example.testovoe.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

public class RouteScheduled {
    @Scheduled(cron = "* * * * * ?")
//    @SchedulerLock(name = "extensionScheduleRoutes", lockAtMostForString = "PT15S")
    public void extensionScheduleRoutes() {
        System.out.println("HUI");
//        List<RouteEntity> routeEntities = routeService.findAll();
//        routeEntities.forEach(item -> {
//            LocalDate startTime = item.getSchedule().getDateEnd();
//            item.getSchedule().setDateEnd(startTime.plusYears(1));
//            List<TourEntity> tourEntities =
//                    ScheduleUtil.scheduledGenerateTours(item, startTime, item.getSchedule().getDateEnd());
//            tourService.saveAll(tourEntities);
//        });
//        routeService.saveAll(routeEntities);
    }

}


