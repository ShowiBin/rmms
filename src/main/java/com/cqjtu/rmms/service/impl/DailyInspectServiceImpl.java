package com.cqjtu.rmms.service.impl;

import com.cqjtu.rmms.entity.DailyInspect;
import com.cqjtu.rmms.mapper.DailyInspectMapper;
import com.cqjtu.rmms.mapper.InspectorMapper;
import com.cqjtu.rmms.mapper.RoadMapper;
import com.cqjtu.rmms.service.DailyInspectService;
import com.cqjtu.rmms.utils.DamageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(rollbackFor = Exception.class)
public class DailyInspectServiceImpl implements DailyInspectService {

    @Autowired
    private DailyInspectMapper dailyInspectMapper;

    @Autowired
    private InspectorMapper inspectorMapper;

    @Autowired
    private RoadMapper roadMapper;

    @Override
    public DailyInspect get(String dailyInspectNo) {

        DailyInspect dailyInspect = null;
        dailyInspect = dailyInspectMapper.selectByPrimaryKey(dailyInspectNo);
        return dailyInspect;

    }

    @Override
    public void addDailyInspect(DailyInspect dailyInspect) {

        dailyInspectMapper.insert(dailyInspect);

    }

    @Override
    public List<DailyInspect> loadAll() {

        return dailyInspectMapper.selectAll();

    }

    @Override
    public void removeDailyInspect(Integer dailyInspectId) {

        dailyInspectMapper.deleteByPrimaryKey(dailyInspectId);

    }

    @Override
    public void updateDailyInspect(DailyInspect dailyInspect) {

        dailyInspectMapper.updateByPrimaryKey(dailyInspect);

    }

    @Override
    public DailyInspect getDailyInspectById(Integer dailyInspectId) {

        return dailyInspectMapper.selectByPrimaryKey(dailyInspectId);

    }

    @Override
    public List<DailyInspect> loadDistinct() {

        Set<DailyInspect> dailyInspectSet=new TreeSet<>(Comparator.comparing(DailyInspect::getRoad_name));
        dailyInspectSet.addAll(dailyInspectMapper.selectAll());
        return new ArrayList<>(dailyInspectSet);

    }

    @Override
    public List<DailyInspect> select(DailyInspect dailyInspect){

        return dailyInspectMapper.select(dailyInspect);

    }


}