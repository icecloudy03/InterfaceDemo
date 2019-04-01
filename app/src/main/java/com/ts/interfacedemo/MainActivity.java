package com.ts.interfacedemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tl_main)
    TabLayout tlMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.bt_main)
    Button btMain;
    private SimpleFragmentPagerAdapter pagerAdapter;
    private FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        vpMain.setAdapter(pagerAdapter);
        tlMain.setupWithViewPager(vpMain);
    }

    /**
     * 执行方法
     * tag: fragment.getTag()
     */
    public void toImplementsInterface(String tag) {
        BaseFrg baseFrg = (BaseFrg) manager.findFragmentByTag(tag);
        FunctionManager functionManager = FunctionManager.getInstance();
        baseFrg.setFunctionManager(functionManager.addFunction(new FunctionNoParamNoResult("frag1") {
            @Override
            protected void function() {
                Toast.makeText(getApplicationContext(), "我执行了没有参数没有返回值的方法", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamWithResult<String, String>("有参数有返回值") {
            @Override
            protected String function(String s) {
                return "这是返回的结果";
            }
        }));
    }

    @OnClick(R.id.bt_main)
    public void onViewClicked() {

    }
}
