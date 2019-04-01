package com.ts.interfacedemo;

import android.text.TextUtils;

import java.util.HashMap;


public class FunctionManager {

    private static HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private static HashMap<String, FunctionWithParamWithResult> mFunctionWithParamWithResult;
    private static HashMap<String, FunctionWithParamNoResult> mFunctionWithParamNoResult;
    private static HashMap<String, FunctionNoParamWithResult> mFunctionNoParamWithResult;

    private static FunctionManager functionManager;

    private FunctionManager() {
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamWithResult = new HashMap<>();
        mFunctionWithParamNoResult = new HashMap<>();
        mFunctionNoParamWithResult = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (functionManager == null) {
            functionManager = new FunctionManager();
        }
        return functionManager;
    }

    /**
     * 添加无参数无返回值
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamNoResult function) {
        if (mFunctionNoParamNoResult != null) {
            mFunctionNoParamNoResult.put(function.funName, function);
        }
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamWithResult function) {
        if (mFunctionWithParamWithResult != null) {
            mFunctionWithParamWithResult.put(function.funName, function);
        }
        return this;
    }

    /**
     * 执行没参数没返回值的
     *
     * @param key
     */
    public void invokeFunction(String key) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        if (mFunctionNoParamNoResult != null) {
            FunctionNoParamNoResult functionNoParamNoResult = mFunctionNoParamNoResult.get(key);
            if (functionNoParamNoResult != null) {
                functionNoParamNoResult.function();
            } else {
                try {
                    throw new Exception("function not found");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 有参数有返回值
     *
     * @param key       调用的方法名
     * @param param     参数
     * @param result    返回结果
     * @param <Result>
     * @param <Param>
     * @return
     */
    public <Result, Param> Result invokeFunction(String key, Param param, Class<Result> result) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (mFunctionWithParamWithResult != null) {
            FunctionWithParamWithResult f = mFunctionWithParamWithResult.get(key);
            if (f != null) {
                if (result == null) {
                    return (Result) f.function(param);
                } else {
                    return result.cast(f.function(param));
                }

            } else {
                try {
                    throw new Exception("function not found");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
