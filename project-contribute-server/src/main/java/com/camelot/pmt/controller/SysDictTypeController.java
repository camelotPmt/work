package com.camelot.pmt.controller;

import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.service.SysDictTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @Author:       lxk
* @CreateDate:  2018/5/9 16:49
* @Description: 系统数据字典类型controller
*/
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {

    @Autowired
    SysDictTypeService sysDictTypeService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody SysDictType sysDictType){
        Integer result = sysDictTypeService.add(sysDictType);
        if(result > 0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok(500);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(Integer id,String code){
        Integer result = sysDictTypeService.delete(id,code);
        if(result > 0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok(500);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody SysDictType sysDictType){
        Integer result = sysDictTypeService.update(sysDictType);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity get(Integer id){
        SysDictType sysDictType = sysDictTypeService.get(id);
        return ResponseEntity.ok(sysDictType);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestBody SysDictType sysDictType){
        List<SysDictType> sysDictTypeList = sysDictTypeService.list(sysDictType);
        return ResponseEntity.ok(sysDictTypeList);
    }

    /**
     * 日期属性编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        // true允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
