package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Label;
import com.demo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;
    /*
    * 添加一个标签
    * */
    @PostMapping("/insert")
    public ResultBody insert(@RequestParam("label") String label){
        if(label.equals("")){
            return ResultBody.exception500("label值不能为空");
        }
        if(labelService.selectSelfAdd(label) != null){
            return ResultBody.exception500("该标签已存在");
        }
        labelService.insert(label);
        return ResultBody.success();
    }

    /*
    * 修改一个标签
    * */
    @PostMapping("/update")
    public ResultBody update(@RequestParam("newLabel") String newLabel, @RequestParam("oldLabel") String oldLabel){
        labelService.update(newLabel,oldLabel);
        return ResultBody.success();
    }

    /*
    * 查询所有label
    * */
    @PostMapping("/showAll")
    public ResultBody showAll(){
        List<Label> labels = labelService.selectAll();
        return ResultBody.success(labels);
    }


}
