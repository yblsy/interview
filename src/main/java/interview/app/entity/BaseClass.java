package interview.app.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘晨
 * @create 2018-05-06 21:38
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
@Getter
@Setter
public class BaseClass extends BaseEntity {

    private static final long serialVersionUID = -1064080574401025929L;

    private String id;

    private String name;

    private String parent_id;

    private String parent_name;

    private String level;
}
