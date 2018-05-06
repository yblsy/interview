package interview.common.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import personal.result.BaseResult;

/**
 * @author 刘晨
 * @create 2018-04-13 13:45
 * To change this template use File | Settings | Editor | File and Code Templates.
 **/
public class InterviewResult extends BaseResult {

    @Getter
    enum InterviewResultConstant{

        I_RC_SUCCESS("00","成功"),
        I_RC_FAILED("01","失败")
        ;

        private String code;
        private String message;

        InterviewResultConstant(String code,String message){
            this.code = code;
            this.message = message;
        }
    }

    public InterviewResult(InterviewResultConstant interviewResultConstant, Object data) {
        super(interviewResultConstant.getCode(), interviewResultConstant.getMessage(), data);
    }

    public static InterviewResult success(){
        return success(null, null);
    }


    public static InterviewResult success(Object data, String message){
        InterviewResult interviewResult = new InterviewResult(InterviewResultConstant.I_RC_SUCCESS, data);
        if(StringUtils.isNotBlank(message)){
            interviewResult.setMessage(message);
        }
        return interviewResult;
    }

    public static InterviewResult error(String message){
        InterviewResult interviewResult = new InterviewResult(InterviewResultConstant.I_RC_FAILED, null);
        if(StringUtils.isNotBlank(message)){
            interviewResult.setMessage(message);
        }
        return interviewResult;
    }

    public static InterviewResult error(Object data, String message){
        InterviewResult interviewResult = new InterviewResult(InterviewResultConstant.I_RC_FAILED, data);
        if(StringUtils.isNotBlank(message)){
            interviewResult.setMessage(message);
        }
        return interviewResult;
    }
}