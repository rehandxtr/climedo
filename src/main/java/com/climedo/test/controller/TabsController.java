package com.climedo.test.controller;

import com.climedo.test.model.Tabs;
import com.climedo.test.service.TabsServiceImplementation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tabs")
public class TabsController {
    @Autowired
    TabsServiceImplementation service;
    @PostMapping
    public ResponseEntity<?> storeTabs(@RequestBody @NonNull Tabs tabs){
        try {
            service.storeTabs(tabs);
            return new ResponseEntity<>("Saved success", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error in saving data",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<?> getTabs() {
        try {
            return new ResponseEntity<>(service.getAllTabs(),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error in fetching data",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{tabId}")
    public ResponseEntity<?> updateTabs(@PathVariable String tabId, @RequestBody Tabs tabs) {
        try {
            if(service.updateTabs(tabId,tabs)) {
                return new ResponseEntity<>("update success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("data not found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>("error in updating data",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{tabId}")
    public ResponseEntity<?> deleteTabs(@PathVariable String tabId) {
        try {
            if(service.deleteTabs(tabId)){
                return new ResponseEntity<>("deleted the data",HttpStatus.OK);
            } else {
                return new ResponseEntity<>("data not found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>("error in deleting data",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
