package world.sai.steward.web.model;

import lombok.Getter;
import lombok.Setter;
import world.sai.steward.util.LogUtil;

/**
 * Created by sai on 2016. 3. 18..
 */
@Getter
@Setter
public class ApiError {
    private ApiErrorType type;
    private ApiErrorCode code;
    private String message;
    private String errorStack;

    public ApiError() {
        type = ApiErrorType.UNKNOWN;
    }

    public ApiError(ApiErrorType type, ApiErrorCode code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public ApiError(ApiErrorType type, ApiErrorCode code, String message, Throwable e) {
        this.type = type;
        this.code = code;
        this.message = message;
        this.errorStack = LogUtil.getStackTrace(e);
    }

    public ApiError(Throwable e) {
        this.type = ApiErrorType.UNKNOWN;
        this.code = ApiErrorCode.UNKNOWN_SERVER_ERROR;
        this.message = e.toString();
        this.errorStack = LogUtil.getStackTrace(e);
    }

    public ApiError(Throwable e, String message, ApiErrorCode code) {
        this.type = ApiErrorType.UNKNOWN;
        this.message = message;
        this.code = code;
        this.message = e.toString();
        this.errorStack = LogUtil.getStackTrace(e);
    }
}

