package com.travel.shahara.exceptions;

public class ShaRuntimeException extends RuntimeException {
    public ShaRuntimeException(){
        super();
    }

    public ShaRuntimeException(String message){
        super(message);
    }

    public ShaRuntimeException(String message, Throwable cause){
        super(message, cause);
    }

    public ShaRuntimeException(Throwable cause){
        super(cause);
    }

    public ShaRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
