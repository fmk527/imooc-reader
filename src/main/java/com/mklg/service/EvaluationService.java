package com.mklg.service;

import com.mklg.pojo.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mklg.vo.EvaluationVo;

import java.util.ArrayList;

/**
* @author fmk
* @description 针对表【evaluation】的数据库操作Service
* @createDate 2022-11-18 21:26:57
*/
public interface EvaluationService extends IService<Evaluation> {

    ArrayList<EvaluationVo> selectById(Long id);

    void insertEvaluation(Evaluation evaluation);

    void updateEnjoy(Long evaluationId);
}
