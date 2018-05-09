package interview.app.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 刘晨
 * @create 2018-05-06 22:36
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Setter
@Getter
@TableName("seq_conf")
public class SeqConf extends Model<SeqConf> implements Serializable{
    private static final long serialVersionUID = -4522299517950499804L;

    public SeqConf(){

    }

    public SeqConf(String seqName){
        this.seqName = seqName;
    }

    @TableId("seq_name")
    private String seqName;

    @TableField("seq_start")
    private Integer seqStart;

    @TableField("seq_end")
    private Integer seqEnd;

    @TableField("seq_step")
    private Integer seqStep;

    @TableField("seq_current")
    private Integer seqCurrent;

    @Override
    protected Serializable pkVal() {
        return this.seqName;
    }
}
