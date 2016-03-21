package world.sai.steward.web.model;

/**
 * Created by sai on 2016. 3. 18..
 */
public enum ApiErrorCode {
    UNKNOWN_SERVER_ERROR,
    DUPLICATE_LOGIN_ID,
    INCORRECT_LOGIN_ID_AND_PASSWORD,
    INVALIDATE_ACCESS_TOKEN,
    EXPIRED_ACCESS_TOKEN,
    DUPLICATE_CODE,
    NO_PERMISSION,
    NOT_FOUND
}
