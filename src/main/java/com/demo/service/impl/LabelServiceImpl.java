package com.demo.service.impl;


import com.demo.mapper.LabelMapper;
import com.demo.pojo.Label;
import com.demo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelMapper labelMapper;

    @Override
    public Integer selectSelfAdd(String label) {
        return labelMapper.selectSelfAdd(label);
    }

    @Override
    public String selectLabel(int selfAdd) {
        return labelMapper.selectLabel(selfAdd);
    }

    @Override
    public boolean insert(String labe) {
        return labelMapper.insert(labe);
    }

    @Override
    public boolean update(String newLabel, String oldLabel) {
        return labelMapper.update(newLabel,oldLabel);
    }

    @Override
    public List<Label> selectAll() {
        return labelMapper.selectAll();
    }
}
