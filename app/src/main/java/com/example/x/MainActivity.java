package com.example.x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toast mytoast;

    public void displayToast(String str) {
        if (mytoast == null) {
            mytoast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
        } else
            mytoast.setText(str);
        mytoast.show();
    }

    private String[] data = {"Apple", "Banana", "Orange", "Watermenlon", "Pear", "Grape",
            "Pineapple", "Strawbrry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermenlon", "Pear", "Grape",
            "Pineapple", "Strawbrry", "Cherry", "Mango"};
    private String[] data1 = {"1", "11", "111", "1111", "111", "11", "1"};
    private List<Txl> txlList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorBule));
                //底部导航栏
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initTxl();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        TxlAdaper adaper = new TxlAdaper(txlList);
        recyclerView.setAdapter(adaper);
    }

    private void initTxl() {
        for (int i = 0; i < 10; i++) {
            Txl one = new Txl("大娃", R.drawable.one, data1[0]);
            txlList.add(one);
            Txl two = new Txl("二娃", R.drawable.two, data1[1]);
            txlList.add(two);
            Txl three = new Txl("三娃", R.drawable.three, data1[2]);
            txlList.add(three);
            Txl four = new Txl("四娃", R.drawable.four, data1[3]);
            txlList.add(four);
            Txl five = new Txl("四娃", R.drawable.five, data1[4]);
            txlList.add(five);
            Txl six = new Txl("六娃", R.drawable.six, data1[5]);
            txlList.add(six);
            Txl seven = new Txl("七娃", R.drawable.seven, data1[6]);
            txlList.add(seven);
        }
    }
}
