package com.climedo.test.service;

import com.climedo.test.model.Tabs;
import com.climedo.test.repository.TabsRepository;
import com.climedo.test.service.implementation.TabsService;
import com.climedo.test.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TabsServiceImplementation implements TabsService {

    @Autowired
    TabsRepository tabsRepository;

    Utils utils = new Utils();

    @Override
    public List<Tabs> getAllTabs() {
        return tabsRepository.findAll();
    }

    @Override
    public void storeTabs(Tabs tabs) {
        Tabs tab = new Tabs();
        tab.setDescription(tabs.getDescription());
        tab.setName(tabs.getName());
        tab.setDataPoints(utils.setValidDataPoints(tabs.getDataPoints()));
        tabsRepository.save(tab);
    }

    @Override
    public Boolean updateTabs(String tabId, Tabs tabs) {
        Optional<Tabs> t = tabsRepository.findById(tabId);
        if(t.isPresent()) {
            Tabs newTab = t.get();
            newTab.setDescription(tabs.getDescription());
            newTab.setName(tabs.getName());
            newTab.setDataPoints(utils.setValidDataPoints(tabs.getDataPoints()));
            newTab.setId(tabId);
            tabsRepository.save(newTab);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteTabs(String tabId) {
        Optional<Tabs> t = tabsRepository.findById(tabId);
        if(t.isPresent()) {
            tabsRepository.deleteById(tabId);
            return true;
        } else {
            return false;
        }
    }
}
