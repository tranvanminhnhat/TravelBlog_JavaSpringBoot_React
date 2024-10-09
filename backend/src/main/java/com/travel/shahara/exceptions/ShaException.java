package com.travel.shahara.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.*;

@Builder
public class ShaException extends Exception {

    @Getter
    @AllArgsConstructor
    public enum ShaHttpsStatus {
        BAD_REQUEST(HttpStatus.BAD_REQUEST),
        NOT_FOUND(HttpStatus.NOT_FOUND),
        CONFLICT(HttpStatus.CONFLICT),
        GONE(HttpStatus.GONE),
        REQUEST_HEADER_FIELDS_TOO_LARGE(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE),
        ;

        private static final Map<Integer, ShaHttpsStatus> ENUMS;

        private final HttpStatus springStatus;

        static {
            ENUMS = new HashMap<>();
            Arrays.stream(values()).forEach(status -> ENUMS.put(status.code(), status));
        }

        public static ShaHttpsStatus valueOf(int code) {
            Integer key = Integer.valueOf(code);

            if (ENUMS.containsKey(key)) {
                return ENUMS.get(key);
            }
            throw new ShaRuntimeException("status code " + code + "not define");


        }

        public int code(){
            return springStatus.value();
        }

        public String reasonPhrase(){
            return springStatus.getReasonPhrase();
        }
    }

    @NonNull
    @Getter
    private final String code;

    @Getter
    private final String subCode;

    @Getter
    @Singular
    private final List<String> args;

    private final String message;

    @NonNull
    @Getter
    private final ShaHttpsStatus httpStatus;

    private final Throwable cause;

    public ShaException(@NonNull String code, String subCode, List<String> args, String message, ShaHttpsStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.subCode = subCode == null ? "" : subCode;
        this.args = Collections.unmodifiableList(args == null ? Collections.emptyList() : args);
        this.message = message;
        this.httpStatus = (httpStatus != null ? httpStatus : ShaHttpsStatus.BAD_REQUEST);
        this.cause = cause;
    }
}
