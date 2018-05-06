package interview.common.enums;

/**
 * @author 刘晨
 * @create 2018-05-06 22:54
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
public enum SeqConfEnum {

    T_BASE_CLASS("SEQ_BASE_CLASS","表Base_Class序列"),
    ;

    private String code;

    private String value;

    SeqConfEnum(String code,String value){
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
