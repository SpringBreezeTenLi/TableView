package com.huading.tableview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.huading.tableviews.LockTableView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            ArrayList<String> strings = new ArrayList<>();
            if (i == 0) {
                strings.add("临期产品");
                strings.add("过期产品");
                strings.add("存货超拣货");
                strings.add("退货24h待上架");
                strings.add("基础资料审核未通过");
                strings.add("温湿度预警");
            } else {
                strings.add("" + i);
                strings.add("2022061600" + i);
                strings.add("脆香毛肚");
                strings.add("2022-06-16");
                strings.add("2022-08-16");
                strings.add("30");
            }
            lists.add(strings);
        }

        LockTableView tableView = new LockTableView(this,linearLayout, lists);
        tableView.setLockFristRow(true)
                .setLockFristColumn(false)
                .setMaxColumnWidth(100)
                .setMinColumnWidth(60)
                .setMaxRowHeight(60)
                .setMinRowHeight(20)
                .setTextViewSize(12)
                .setCellPadding(8)
                .setNullableString("N/A")
                .setOnItemSeletor(R.color.green)
                .show();

    }
}