package com.envest.markdown.service;

import com.envest.markdown.business.response.BaseResult;
import com.envest.markdown.dal.entity.MarkDownEntity;

/**
 * Created by 41408 on 2018/11/22.
 */
public interface MarkDownService {
    BaseResult save(MarkDownEntity markDownEntity);

    BaseResult queryList();

    BaseResult queryById(String id);
}
