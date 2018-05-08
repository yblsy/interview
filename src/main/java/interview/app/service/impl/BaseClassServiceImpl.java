package interview.app.service.impl;

import com.google.common.base.Strings;
import interview.app.entity.BaseClass;
import interview.app.entity.SeqConf;
import interview.app.inner.InnerBaseClassComponent;
import interview.app.service.BaseClassService;
import interview.app.service.SeqConfService;
import interview.common.enums.SeqConfEnum;
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
        baseClass.setId(seqConfService.getId(SeqConfEnum.T_BASE_CLASS.getCode()));
        return innerBaseClassComponent.insertBaseClass(baseClass);
    }

    @Override
    public List<BaseClass> queryBaseClassesByParentId(String parentId) {
        return innerBaseClassComponent.selectBaseClassesByParentId(Strings.emptyToNull(parentId));
    }
}
