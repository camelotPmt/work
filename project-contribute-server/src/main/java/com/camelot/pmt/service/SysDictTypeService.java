package com.camelot.pmt.service;

import com.camelot.pmt.model.SysDictType;

import java.util.List;

public interface SysDictTypeService {
    Integer add(SysDictType sysDictType);

    Integer delete(Integer id, String code);

    Integer update(SysDictType sysDictType);

    SysDictType get(Integer id);

    List<SysDictType> list(SysDictType sysDictType);
}
