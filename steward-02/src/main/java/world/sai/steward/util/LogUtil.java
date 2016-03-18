package world.sai.steward.util;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 로그 유틸
 */
public class LogUtil {

    /**
     * 모든 Error Stack 을 문자열로 보여준다.
     * @param e 출력할 Throwable
     * @return 에러 스택 문자열
     * @deprecated getStackTrace 메서드로 대체
     */
    @Deprecated
    public static String getStrackTrace(Throwable e) {
        StringBuffer buffer = new StringBuffer();
        printStackTrace(buffer, e, false);
        return buffer.toString();
    }

    /**
     * 모든 Error Stack 을 문자열로 보여준다.
     * @param e 출력할 Throwable
     * @return 에러 스택 문자열
     */
    public static String getStackTrace(Throwable e) {
        StringBuffer buffer = new StringBuffer();
        printStackTrace(buffer, e, false);
        return buffer.toString();
    }

    /**
     * StackTrace 를 문자열로 보여준다.
     * @param stackTraceElements 출력할 스택
     * @return 스택 문자열
     */
    public static String getStackTrace(StackTraceElement[] stackTraceElements) {
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i < stackTraceElements.length; i++) {
            buffer.append("\tat " + stackTraceElements[i]);
            buffer.append("\r\n");
        }
        return buffer.toString();
    }



    /**
     * 모든 Error Stack 을 파일에 기록한다. 기존 파일이 있을 경우 내용을 추가한다.
     * @param logFile Error Stack 을 추가할 파일
     * @param e 기록할 Error
     */
    public static void log(File logFile, Throwable e) {
        log(logFile, e, null);
    }

    /**
     * 모든 Error Stack 을 파일에 기록한다. 기존 파일이 있을 경우 내용을 추가한다.
     * @param logFile Error Stack 을 추가할 파일
     * @param e 기록할 Error
     * @param appendMessage 에러 스택 상단에 추가할 추가 메세지. null 일 경우 기록하지 않는다.
     */
    public static void log(File logFile, Throwable e, String appendMessage) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(logFile, true);
            if(appendMessage != null) {
                IOUtils.write("\n" + appendMessage, fos);
            }
            IOUtils.write("\n" + getStrackTrace(e), fos);
        } catch (FileNotFoundException e1) {
            throw new RuntimeException(e1);
        }catch (IOException e1) {
            throw new RuntimeException(e1);
        }finally {
            IOUtils.closeQuietly(fos);
        }
    }

    /**
     *
     * @param buffer
     * @param e 조회할 Throwable
     * @param cause Cause 표시 여부
     */
    private static void printStackTrace(StringBuffer buffer, Throwable e, boolean cause) {
        if(cause) {
            buffer.append("Caused by: ");
        }
        buffer.append(e);
        buffer.append("\r\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (int i=0; i < trace.length; i++) {
            buffer.append("\tat " + trace[i]);
            buffer.append("\r\n");
        }
        Throwable ourCause = e.getCause();
        if (ourCause != null) {
            printStackTrace(buffer, ourCause, true);
        }
    }
}
