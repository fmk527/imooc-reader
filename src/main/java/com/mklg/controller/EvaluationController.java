package com.mklg.controller;

import com.mklg.pojo.Evaluation;
import com.mklg.service.EvaluationService;
import com.mklg.util.Result;
import com.mklg.vo.EvaluationVo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static org.apache.ibatis.ognl.DynamicSubscript.mid;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Resource
    private EvaluationService evaluationService;

    @GetMapping("/id/{id}")
    public Result<ArrayList<EvaluationVo>> selectById(@PathVariable("id") Long id) {
       ArrayList<EvaluationVo> evaluation = evaluationService.selectById(id);
        return Result.success(evaluation);
    }
//                axios.post("/api/evaluation/" + mid + "/" + bid).then(res => {
    @PostMapping()
    public Result<String> putEvaluation(@RequestBody Evaluation evaluation) {
        evaluationService.insertEvaluation(evaluation);
        return Result.success();
    }
    @PostMapping("/enjoy/{evaluationId}")
    public Result<Objects> updateEnjoy(@PathVariable("evaluationId")Long evaluationId) {
        evaluationService.updateEnjoy(evaluationId);
        return Result.success();
    }
}
