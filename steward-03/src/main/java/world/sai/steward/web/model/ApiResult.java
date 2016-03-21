package world.sai.steward.web.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sai on 2016. 3. 18..
 */
@Getter
@Setter
public class ApiResult<T> {
    private boolean success = true;
    private String version = "v1";
    private ApiError error;
    private T data;

    public ApiResult() {

    }

    public ApiResult(T data) {
        this.data = data;
    }

    public ApiResult(Throwable e, ApiErrorCode errorCode, String message) {
        this.error = new ApiError(ApiErrorType.UNKNOWN, errorCode, message, e);
        this.success = false;
    }

    public ApiResult(Throwable e) {
        this.error = new ApiError(e);
        this.success = false;
    }

    public ApiResult(ApiErrorType type, ApiErrorCode errorCode, String message) {
        this.error = new ApiError(type, errorCode, message);
        this.success = false;
    }
}

