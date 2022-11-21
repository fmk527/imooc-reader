package com.mklg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mklg.config.SystemException;
import com.mklg.pojo.Evaluation;
import com.mklg.service.EvaluationService;
import com.mklg.mapper.EvaluationMapper;
import com.mklg.vo.EvaluationVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
* @author fmk
* @description 针对表【evaluation】的数据库操作Service实现
* @createDate 2022-11-18 21:26:57
*/
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)//默认不使用事务
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService{
    @Resource
    private EvaluationMapper evaluationMapper;
    @Override
    public ArrayList<EvaluationVo> selectById(Long id) {
        return evaluationMapper.select(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertEvaluation(Evaluation evaluation) {
        evaluation.setCreateTime(new Date());
        int insert = evaluationMapper.insert(evaluation);
        if(insert <= 0){
            throw new SystemException("评论数据异常！");
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateEnjoy(Long evaluationId) {
       Integer update = evaluationMapper.updateEnjoy(evaluationId);
       if(update <= 0){
           throw new SystemException("数据异常，请重新尝试！");
       }
    }
}




