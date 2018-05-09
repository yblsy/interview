package interview.app.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 刘晨
 * @create 2018-05-06 21:34
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Getter
@Setter
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -8593976464862192681L;

    protected String createUser;

    protected Timestamp createTime;

    protected String updateUser;

    protected Timestamp updateTime;

    @TableField("is_delete")
    protected Integer isDelete = 0;

}
