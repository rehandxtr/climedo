package com.climedo.test.controller;

import com.climedo.test.model.Tabs;
import com.climedo.test.model.TabStats;
import com.climedo.test.service.TabsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class TabStatsController {
    @Autowired
    TabsServiceImplementation service;

    @GetMapping("/tabStats")
    public ResponseEntity<?> getTAbStats() {
        try {
            List<Tabs> tabs = service.getAllTabs();
            List<TabStats> tabStatsList = new ArrayList<>();
            for (Tabs t : tabs) {
                TabStats tabStats = new TabStats();
                tabStats.setId(t.getId());
                tabStats.setDataPointCount(t.getDataPoints().size());
                tabStatsList.add(tabStats);
            }
            Comparator<TabStats> byCount = Comparator.comparing(TabStats::getDataPointCount);
            tabStatsList.sort(byCount);
            return new ResponseEntity<>(tabStatsList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error in fetching data", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
