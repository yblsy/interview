package interview.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import interview.app.entity.SeqConf;
import interview.app.mapper.SeqConfMapper;
import interview.app.service.SeqConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘晨
 * @create 2018-05-06 22:42
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Service
public class SeqConfServiceImpl implements SeqConfService {

    @Autowired(required = false)
    private SeqConfMapper seqConfMapper;

    @Override
    @Transactional(readOnly = false,rollbackFor = {Exception.class})
    public String getId(String seqName) {
        String result = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        // 查询出指定序列的当前值，并且进行更新
        SeqConf seqConf = seqConfMapper.selectOne(new SeqConf(seqName));
        result = String.format(simpleDateFormat.format(new Date())+"%06d",seqConf.getSeqCurrent());
        //更新当前序列
        seqConf.setSeqCurrent(seqConf.getSeqCurrent() + seqConf.getSeqStep());
        //如果序列值为最大值，则归零
        if(seqConf.getSeqCurrent() > 999999){
            seqConf.setSeqCurrent(seqConf.getSeqStart());
        }
        seqConfMapper.updateAllColumnById(seqConf);
        return result;
    }
}
