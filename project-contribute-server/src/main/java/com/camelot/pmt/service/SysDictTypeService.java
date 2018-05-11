package com.camelot.pmt.service;

import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.model.SysDictTypeDTO;
import com.github.pagehelper.PageInfo;

public interface SysDictTypeService {
    Integer add(SysDictType sysDictType);

    Integer delete(Integer id, String code);

    Integer update(SysDictType sysDictType);

    SysDictType get(Integer id);

    PageInfo list(SysDictTypeDTO sysDictTypeVO);
}
