package com.climedo.test.repository;

import com.climedo.test.model.Tabs;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TabsRepository extends MongoRepository<Tabs, String> {
    public Optional<Tabs> findById(String tabId);
}
