package com.ts.interfacedemo;

public abstract class FunctionWithParamNoResult<Param> extends Function {

    public FunctionWithParamNoResult(String functionName) {
        super(functionName);
    }

    protected abstract void function(Param param);
}
