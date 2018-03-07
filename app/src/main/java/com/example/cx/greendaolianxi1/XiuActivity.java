package com.example.cx.greendaolianxi1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.greebdao.gen.XiguaDao;

public class XiuActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText sex;
    private EditText age;
    private long id;
    private Button xiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu);
        initView();
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 20);


    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        sex = (EditText) findViewById(R.id.sex);
        age = (EditText) findViewById(R.id.age);
        xiu = (Button) findViewById(R.id.xiu);
        xiu.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "请输入您要修改的", Toast.LENGTH_SHORT).show();
            return;
        }

        String sexString = sex.getText().toString().trim();
        if (TextUtils.isEmpty(sexString)) {
            Toast.makeText(this, "请输入您要修改的", Toast.LENGTH_SHORT).show();
            return;
        }

        String ageString = age.getText().toString().trim();
        if (TextUtils.isEmpty(ageString)) {
            Toast.makeText(this, "请输入您要修改的", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.xiu:

               XiguaDao xiguaDao = MyAppaction.getApplication().getDaoSession().getXiguaDao();
               Xigua xigua = new Xigua();
               xigua.setId((Long)id);
               xigua.setSex(sex.getText().toString());
               xigua.setName(name.getText().toString());
               xigua.setAge(age.getText().toString());


                xiguaDao.update(xigua);
                finish();

               break;
        }
    }
}
