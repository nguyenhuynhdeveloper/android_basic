package com.example.android_basic.BroadcastReceiver_demoReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_basic.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  static  final  String MY_ACTION = "com.tinCoder.ACTION";
    private static final String MY_KEY = "com.tinCoder.KEY";

    private   BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (MY_ACTION.equals(intent.getAction())) {
                // Nhận 1 Object
//                String jsonUser = intent.getStringExtra(MY_KEY);
//             Gson gson = new Gson();
//             User user = gson.fromJson(jsonUser, User.class);
//             tvReceived.setText("User id " + user.getId() +  "User namr: " + user.getName());
                // Nhận 1 list Object
                 String strJson = intent.getStringExtra(MY_KEY);
                 List<User> list = getListUser(strJson);
String listUsername = "";
                 for (int i = 0 ; i< list.size(); i++){
                     listUsername= listUsername + list.get(i).getName() + "\n";

                 }

             tvReceived.setText(listUsername);



            }
        }
    };

private TextView tvReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvReceived = findViewById(R.id.tv_BroadcastReceiver_Object);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }
// HÀm sử lý chuyển từ String sang list Object
    private List<User> getListUser(String strJson) {
 List<User> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            JSONObject jsonObject;   // Cái này phải lấy từ org.json
            User user;
            Gson gson   = new Gson();
            for (int i = 0; i< jsonArray.length() ; i++) {
                jsonObject = jsonArray.getJSONObject(i);
                user = gson.fromJson(jsonObject.toString(), User.class);
                list.add(user);
            }
 }catch (JSONException e) {
     e.printStackTrace();
 }
        return list;
    };
}