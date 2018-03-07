package com.example.cx.greendaolianxi1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.greebdao.gen.XiguaDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recy;
    private XiguaDao xiguaDao;
    private List<Xigua> xiguas;
    private RecyAdapter adapter;
    private EditText sou;
    private Button cha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    @Override
    protected void onResume() {


        super.onResume();

        ononon();
    }

    private void ononon() {

        xiguas = xiguaDao.loadAll();
        LinearLayoutManager lin = new LinearLayoutManager(MainActivity.this);
        adapter = new RecyAdapter(xiguas, MainActivity.this);
        recy.setLayoutManager(lin);
        recy.setAdapter(adapter);
        initListener();
    }

    private void initData() {
        xiguaDao = MyAppaction.getApplication().getDaoSession().getXiguaDao();
        if (xiguaDao.loadAll().size() == 0) {
            for (int i = 0; i < 10; i++) {
                Xigua xigua = new Xigua();
                xigua.setAge("20" + i);
                xigua.setName("小东西长的" + i);
                xigua.setSex("公");

                xiguaDao.insert(xigua);
            }

        }


    }

    private void initListener() {
        adapter.setonClickListener(new RecyAdapter.onClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, XiuActivity.class);
                intent.putExtra("id", xiguas.get(position).getId());

                startActivity(intent);
//18634479194
            }

            @Override
            public void OnItemLongClick(int position) {
                xiguaDao.deleteByKey(xiguas.get(position).getId());
                ononon();
            }
        });

    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        sou = (EditText) findViewById(R.id.sou);
        sou.setOnClickListener(this);
        cha = (Button) findViewById(R.id.cha);
        cha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cha:


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                List<Xigua> list = xiguaDao.queryBuilder().where(XiguaDao.Properties.Name.eq(sou.getText().toString())).list();
                adapter = new RecyAdapter(list, MainActivity.this);
                recy.setLayoutManager(linearLayoutManager);
                recy.setAdapter(adapter);
                initListener();


                break;
        }
    }

    private void submit() {
        // validate
        String souString = sou.getText().toString().trim();
        if (TextUtils.isEmpty(souString)) {
            Toast.makeText(this, "请输入您要搜索的", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
