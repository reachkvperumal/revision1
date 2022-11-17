package com.exception;

@FunctionalInterface
public interface WriteFunctionWithExceptionHdlr<T, R, E extends Throwable> {

    R apply(T  t) throws E;

    static <T, R, E extends Throwable> R write(WriteFunctionWithExceptionHdlr<T, R, E> func, T t){
        try {
            return func.apply(t);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
