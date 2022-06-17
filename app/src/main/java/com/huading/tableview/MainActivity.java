package com.huading.tableview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huading.tableviews.DisplayUtil;
import com.huading.tableviews.HeaderBean;
import com.huading.tableviews.LockTableView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HeaderBean> headerBeans;
    private ArrayList<ArrayList<String>> lists;
    private LockTableView tableView;
    private LinearLayout lockLinear, rowLinear, linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lockLinear = (LinearLayout) findViewById(R.id.lockLinear);
        rowLinear = (LinearLayout) findViewById(R.id.rowLinear);
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        lists = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("" + i);
            strings.add("张三");
            strings.add("" + (10000 - i * 10));
            strings.add("1000");
            strings.add("3000");
            strings.add("" + (1000 - i));
            lists.add(strings);
        }

        ArrayList<String> strings = new ArrayList<>();
        strings.add("排名");
        strings.add("员工");
        strings.add("拣货件数");
        strings.add("本周累计");
        strings.add("本月累计");
        strings.add("季度结算");

        headerBeans = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            headerBeans.add(new HeaderBean(strings.get(i), 0, i > 1));
        }

        tableView = new LockTableView(this, linearLayout, headerBeans, lists);
        tableView.setLockFristRow(false)
                .setLockFristColumn(false)
                .setMaxColumnWidth(60)
                .setMinColumnWidth(60)
                .setMaxRowHeight(30)
                .setMinRowHeight(30)
                .setTextViewSize(10)
                .setCellPadding(8)
                .setNullableString("N/A")
                .setHeaderBgColor(R.color.review_pep)
                .setFristRowBackGroudColor(R.color.white)
                .setTableHeadTextColor(R.color.text_color)
                .setTableContentTextColor(R.color.text_color)
                .setOnItemSeletor(R.color.ll_graybg)
                .setHeaderViewClickListener(new LockTableView.OnHeaderViewClickListener() {
                    @Override
                    public void onItemHeaderClicked(int position) {
                        decByHeaderData(position);
                    }
                })
                .show();
    }

    private void decByHeaderData(int position) {
        for (int i = 0; i < headerBeans.size(); i++) {
            HeaderBean bean = headerBeans.get(i);
            int clickCount = bean.getClickCount();
            if (i == position) {
                switch (clickCount) {
                    case 0: {
                        clickCount = 1;
                        break;
                    }
                    case 1: {
                        clickCount = 2;
                        break;
                    }
                    case 2: {
                        clickCount = 0;
                        break;
                    }
                }
            } else {
                clickCount = 0;
            }
            bean.setClickCount(clickCount);
        }
        tableView.setTableDatas(headerBeans, lists);
    }

    private void addOneRowed(LinearLayout layout) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("临期产品");
        strings.add("过期产品");
        strings.add("存货超拣货");
        strings.add("退货24h待上架");
        strings.add("基础资料审核未通过");
        strings.add("温湿度预警");

        layout.removeAllViews();
        for (int i = 0; i < strings.size(); i++) {
            //构造单元格
            TextView textView = new TextView(this);
            textView.setTextColor(ContextCompat.getColor(this, R.color.black));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
            textView.setGravity(Gravity.CENTER);
            textView.setText(strings.get(i));
            //设置布局
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            textViewParams.setMargins(8, 8, 8, 8);
            textViewParams.height = DisplayUtil.dip2px(this, 30);
            textViewParams.width = DisplayUtil.dip2px(this, 60);
            textView.setLayoutParams(textViewParams);
            layout.addView(textView);
            //画分隔线
            if (i != strings.size() - 1) {
                View splitView = new View(this);
                ViewGroup.LayoutParams splitViewParmas = new ViewGroup.LayoutParams(DisplayUtil.dip2px(this, 1),
                        ViewGroup.LayoutParams.MATCH_PARENT);
                splitView.setLayoutParams(splitViewParmas);
                splitView.setBackgroundColor(ContextCompat.getColor(this, com.huading.tableviews.R.color.light_gray));
                layout.addView(splitView);
            }
        }
    }

}