package com.ts.interfacedemo;

public abstract class FunctionNoParamWithResult<Result> extends Function {

    public FunctionNoParamWithResult(String functionName) {
        super(functionName);
    }

    protected  abstract Result function();
}
