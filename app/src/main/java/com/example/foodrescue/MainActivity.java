package com.example.foodrescue;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greendao.db.bean.Food;
import com.greendao.db.helper.FoodHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    List<Object> mItems = new ArrayList<>();
    MultiTypeAdapter mAdapter = new MultiTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
        mAdapter.register(Food.class, new FoodViewBinder(new FoodViewBinder.OnItemClick() {
            @Override
            public void onItem(Food item) {

            }

            @Override
            public void onShareItem(int position, Food item) {

                item.setType(1);
                FoodHelper.update(item);
                Toast.makeText(MainActivity.this, "Share success", Toast.LENGTH_SHORT).show();

            }
        }));

        mAdapter.setItems(mItems);


    }

    @Override
    protected void onResume() {
        super.onResume();

        initList();
    }

    private void initList() {

        List<Food> list = FoodHelper.findAll(mType);
        mItems.clear();
        mItems.addAll(list);
        mAdapter.notifyDataSetChanged();

    }

    private int mType;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                mType = 0;
                initList();
                break;
            case R.id.account:
                startActivity(new Intent(this, AccountActivity.class));
                break;
            case R.id.myList:
                mType = 1;
                initList();
                break;
        }
        return true;
    }

    @OnClick(R.id.addBtn)
    public void onClick() {

        startActivity(new Intent(this, AddActivity.class));

    }
}