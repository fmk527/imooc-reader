package com.mklg.mapper;

import com.mklg.pojo.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mklg.vo.EvaluationVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
* @author fmk
* @description 针对表【evaluation】的数据库操作Mapper
* @createDate 2022-11-18 21:26:57
* @Entity com.mklg.pojo.Evaluation
*/
public interface EvaluationMapper extends BaseMapper<Evaluation> {

    ArrayList<EvaluationVo> select(@Param("book_id") Long id);

    Integer updateEnjoy(Long evaluationId);
}




