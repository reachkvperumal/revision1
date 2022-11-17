package com.exception.impl;

import com.exception.ReadFunctionWithExceptionHdlr;
import com.mashape.unirest.http.ObjectMapper;
import com.exception.WriteFunctionWithExceptionHdlr;

public class FunctionWithExceptionHdlrImpl {

    private ObjectMapper objectMapper;

    public <T> String getJson(T request){
        return WriteFunctionWithExceptionHdlr.write(objectMapper::writeValue, request);
    }


    public <T> T readValue(String content, Class<T> type){
        return ReadFunctionWithExceptionHdlr.read(objectMapper::readValue,content,type);
    }

}
