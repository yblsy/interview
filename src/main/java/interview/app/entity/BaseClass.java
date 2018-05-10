package interview.app.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 刘晨
 * @create 2018-05-06 21:38
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Getter
@Setter
public class BaseClass extends Model<BaseClass> {

    private static final long serialVersionUID = -1064080574401025929L;

    @TableId
    private String id;

    private String name;

    @TableField("parent_id")
    private String parentId;

    @TableField("parent_name")
    private String parentName;

    private String level;

    private String url;

    @TableField("child_num")
    private Integer childNum;
    
    private String memo;

    @TableField(exist = false)
    private List<BaseClass> childrens;

    protected String createUser;

    protected Date createTime;

    protected String updateUser;

    protected Date updateTime;

    @TableField("is_delete")
    protected Integer isDelete = 0;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
