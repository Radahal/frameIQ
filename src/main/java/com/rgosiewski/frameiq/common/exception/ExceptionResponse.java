package com.rgosiewski.frameiq.common.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExceptionResponse {
    private final Fault fault;

    public ExceptionResponse(HttpStatus httpStatus, Exception exception) {
        this.fault = new Fault(httpStatus.value(), exception);
    }

    public ExceptionResponse(HttpStatus httpStatus, String message, String description, Exception exception) {
        this.fault =  new Fault(httpStatus.value(), message, description, exception);
    }

    public ExceptionResponse(HttpStatus httpStatus, String message, List<Fault.Detail> details) {
        this.fault = new Fault(httpStatus.value(), message, message, details);
    }

    public static class Fault {
        private final int code;
        private final String message;
        private final String description;
        private final List<Detail> details;

        public Fault(int code, String message, String description, List<Detail> details) {
            this.code = code;
            this.message = message;
            this.description = description;
            this.details = details;
        }

        public Fault(int code, String message, String description, Exception exception) {
            this(code, message, description, Collections.singletonList(new Detail(code, exception)));
        }

        public Fault(int code, Exception exception) {
            this(code, exception.getMessage(), exception.getMessage(), Collections.singletonList(new Detail(code, exception)));
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getDescription() {
            return description;
        }

        public List<Detail> getDetails() {
            return details;
        }

        public static class Detail {
            private final String code;
            private final String message;
            private final String description;

            public Detail(String code, String message, String description) {
                this.code = code;
                this.message = message;
                this.description = description;
            }

            public Detail(int code, Exception exception) {
                this(String.valueOf(code), exception.getLocalizedMessage(), Arrays.stream(exception.getStackTrace())
                        .findFirst()
                        .map(StackTraceElement::toString)
                        .orElse(""));
            }

            public String getCode() {
                return code;
            }

            public String getMessage() {
                return message;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}
