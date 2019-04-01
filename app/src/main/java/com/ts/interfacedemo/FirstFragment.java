package com.ts.interfacedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FirstFragment extends BaseFrg {
    @BindView(R.id.tv_one)
    TextView tvOne;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        unbinder = ButterKnife.bind(this, view);
        functionManager.addFunction(new FunctionWithParamWithResult<String,String>("有参数有返回值f2f") {
            @Override
            protected String function(String s) {
                return s + "结果";
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_one)
    public void onViewClicked() {
//        functionManager.invokeFunction("frag1");
        String result = functionManager.invokeFunction("有参数有返回值的方法：Info getUserInfo(param)", "param from fg1", String.class);
        Toast.makeText(getActivity(), "返会的结果是：" + result, Toast.LENGTH_SHORT).show();
    }
}
