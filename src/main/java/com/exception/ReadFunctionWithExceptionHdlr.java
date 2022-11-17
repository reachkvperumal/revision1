package com.exception;

@FunctionalInterface
public interface ReadFunctionWithExceptionHdlr<P, T, R, E extends Throwable> {

    R apply(P p, T t) throws E;

    static  <P, T, R, E extends Throwable> R read(ReadFunctionWithExceptionHdlr<P, T, R, E> func, P p, T t){

        try {
            return func.apply(p,t);
        } catch (Throwable e) {
        throw new RuntimeException(e);
        }

    }

}
