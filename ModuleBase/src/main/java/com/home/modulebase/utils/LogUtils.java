package com.home.modulebase.utils;

public class LogUtils {

    public static void d(String msg) {
        String tag = "more";
        StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
        String fileName = targetStackTraceElement.getFileName();
        int lineNumber = targetStackTraceElement.getLineNumber();
        android.util.Log.d(tag, msg + "  (" + fileName + ":" + lineNumber + ")");
    }

    private static StackTraceElement getTargetStackTraceElement() {
        StackTraceElement targetStackTrace = null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            boolean isLogMethod = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement;
                break;
            }
            shouldTrace = isLogMethod;
        }
        return targetStackTrace;
    }
}
