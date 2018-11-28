package com.envest.markdown.service.impl;

import com.envest.markdown.business.constant.Code;
import com.envest.markdown.business.response.BaseResult;
import com.envest.markdown.dal.entity.MarkDownEntity;
import com.envest.markdown.dal.repository.MarkDownEntityRepo;
import com.envest.markdown.model.MarkDownVo;
import com.envest.markdown.service.MarkDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 41408 on 2018/11/22.
 */

@Service
public class MarkDownImpl implements MarkDownService {

    @Autowired
    MarkDownEntityRepo markDownEntityRepo;

    @Override
    public BaseResult save(MarkDownEntity markDownEntity) {

        MarkDownEntity entity = markDownEntityRepo.save(markDownEntity);

        return new BaseResult(Code.SUCCESS, "提交成功", entity.getId());
    }

    @Override
    public BaseResult queryList() {
        List<MarkDownEntity> list = markDownEntityRepo.findAll();
        return new BaseResult(Code.SUCCESS, list);
    }

    @Override
    public BaseResult queryById(String id) {
        MarkDownEntity markDown = markDownEntityRepo.findById(id);
        return new BaseResult(Code.SUCCESS, markDown);
    }
}
