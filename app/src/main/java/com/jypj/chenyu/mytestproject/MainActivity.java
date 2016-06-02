package com.jypj.chenyu.mytestproject;

import android.app.Activity;
import android.os.Bundle;

import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {



    private List<Integer> datas;
    private ConvenientBanner convenientBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        datas=new ArrayList<>();
        datas.add(R.drawable.image1);
        datas.add(R.drawable.image2);
        datas.add(R.drawable.image3);
        datas.add(R.drawable.image4);
        datas.add(R.drawable.image5);


        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, datas)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_pre, R.drawable.ic_focus})
                        //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        //设置翻页的效果，不需要翻页效果可用不设
                .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);
        //        convenientBanner.setManualPageable(false);//设置不能手动影响

    }

    // 开始自动翻页
    @Override
    protected void onResume() {

        super.onResume();
        convenientBanner.startTurning(2000);

    }


}
