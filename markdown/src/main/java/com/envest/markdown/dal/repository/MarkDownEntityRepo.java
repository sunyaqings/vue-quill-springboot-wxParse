package com.envest.markdown.dal.repository;

import com.envest.markdown.dal.entity.MarkDownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 41408 on 2018/11/22.
 */

@Repository
public interface MarkDownEntityRepo extends JpaRepository<MarkDownEntity, Long> {

    MarkDownEntity findById(String id);

}
