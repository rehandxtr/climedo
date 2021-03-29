package com.climedo.test.service.implementation;

import com.climedo.test.model.Tabs;

import java.util.List;

public interface TabsService {
    public List<Tabs> getAllTabs();
    public void storeTabs(Tabs tabs);
    public Boolean updateTabs(String tabId,Tabs tabs);
    public Boolean deleteTabs(String tabId);
}
