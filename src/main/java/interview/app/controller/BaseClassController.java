package interview.app.controller;

import com.google.common.base.Strings;
import interview.app.entity.BaseClass;
import interview.app.service.BaseClassService;
import interview.common.model.InterviewResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import personal.annotation.BaseResultAnnotation;

import java.util.List;
import java.util.Map;

/**
 * @author 刘晨
 * @create 2018-05-06 22:04
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Controller
@RequestMapping("/class/")
@Slf4j
public class BaseClassController extends BaseController{

    @Autowired
    private BaseClassService baseClassService;

    @RequestMapping("{path}")
    public String to(@PathVariable("path") String path){
        return path;
    }

    @RequestMapping(value = "tomanage",method = RequestMethod.GET)
    public String toManage(){
        return "classes/manage";
    }

    @RequestMapping(value = "queryClass",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @BaseResultAnnotation
    public InterviewResult queryClass(String parentId){
        List<BaseClass> results = baseClassService.queryBaseClassesByParentId(parentId);
        return InterviewResult.success(results,"查询成功");
    }

    @RequestMapping(value = "insertClass",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @BaseResultAnnotation
    public InterviewResult insertClass(BaseClass baseClass){
        Integer result = baseClassService.insertBaseClass(baseClass);
        return InterviewResult.success(result,"新增成功");
    }
}
