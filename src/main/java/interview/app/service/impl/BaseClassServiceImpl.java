package interview.app.service.impl;

import com.google.common.base.Strings;
import interview.app.entity.BaseClass;
import interview.app.entity.SeqConf;
import interview.app.inner.InnerBaseClassComponent;
import interview.app.service.BaseClassService;
import interview.app.service.SeqConfService;
import interview.common.enums.ErrorEnum;
import interview.common.enums.SeqConfEnum;
import interview.common.exceptions.InterviewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘晨
 * @create 2018-05-06 21:41
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Service
public class BaseClassServiceImpl implements BaseClassService {

    @Autowired
    private InnerBaseClassComponent innerBaseClassComponent;

    @Autowired
    private SeqConfService seqConfService;

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Integer insertBaseClass(BaseClass baseClass) {
        int result = 0;
        BaseClass parentClass = null;
        if(!Strings.isNullOrEmpty(baseClass.getParentId())){
            parentClass = innerBaseClassComponent.selectOne(baseClass.getParentId());
            if(parentClass == null){
                throw new InterviewException(ErrorEnum.INTER_BC_ER_000001.getCode(),ErrorEnum.INTER_BC_ER_000001.getValue());
            }
            //该父节点多增加一个子节点
            parentClass.setChildNum(parentClass.getChildNum() + 1);
            result = innerBaseClassComponent.updateBaseClass(parentClass);
            if(result != 1){
                throw new InterviewException(ErrorEnum.INTER_BC_ER_000002.getCode(),ErrorEnum.INTER_BC_ER_000002.getValue());
            }
        }else{
            parentClass = new BaseClass();
            parentClass.setLevel("0");
            parentClass.setParentName(null);
        }

        //增加节点
        baseClass.setId(seqConfService.getId(SeqConfEnum.T_BASE_CLASS.getCode()));
        baseClass.setParentName(parentClass.getParentName());
        baseClass.setLevel("" + (Integer.parseInt(parentClass.getLevel()) + 1));

        result = innerBaseClassComponent.insertBaseClass(baseClass);
        if(result != 1){
            throw new InterviewException(ErrorEnum.INTER_BC_ER_000003.getCode(),ErrorEnum.INTER_BC_ER_000003.getValue());
        }
        return result;
    }

    @Override
    public List<BaseClass> queryBaseClassesByParentId(String parentId) {
        return innerBaseClassComponent.selectBaseClassesByParentId(Strings.emptyToNull(parentId));
    }
}
