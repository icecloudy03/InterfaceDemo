package com.ts.interfacedemo;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseFrg extends Fragment {

    public FunctionManager functionManager;
    private MainActivity mainActivity;

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
            mainActivity.toImplementsInterface(getTag());
        }
    }
}
