package com.ts.interfacedemo;

public abstract class FunctionWithParamWithResult<Result, Param> extends Function {
    public FunctionWithParamWithResult(String functionName) {
        super(functionName);
    }

    protected abstract Result function(Param param);
}