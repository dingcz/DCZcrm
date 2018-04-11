package com.ithc.service;

import java.util.List;

import com.ithc.bean.Dict;

public interface DictService {

	List<Dict> findByCode(String code);

}
