package com.example.android_basic.ViewBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_basic.MainActivity;
import com.example.android_basic.R;
import com.example.android_basic.databinding.ActivityViewBindingDemoBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewBinding_demo extends AppCompatActivity {

    // Cách 1: findViewById : Khai báo -- gán giá trị (Ánh xạ view) --
    private Button btn_click;
    
    //Cách 2: sử dụng thư viện bên ngoài butter knife : nhưng hiện tại đã k được hỗ trợ nữa
    @BindView(R.id.btn_demo_butter_knife)
    Button btn_demo_butter_knife;

    // Cách 3: Trong thẻ android của build.gradlew module app config thêm dòng viewBinding true trong buildFeatures
    // Sau khi khai báo ở build.gradlew
    private ActivityViewBindingDemoBinding mActivityViewBinding ;   //  Trùng với bên của XML

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_view_binding_demo);

        // Cách 3: Cần thay đổi setContentView
        mActivityViewBinding = ActivityViewBindingDemoBinding.inflate(getLayoutInflater());
        setContentView(mActivityViewBinding.getRoot());

        ButterKnife.bind(this);  // Thêm dòng này để config ở onCreate

        // Cách 1:
        Button btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewBinding_demo.this, "Use Findviewbyid", Toast.LENGTH_SHORT).show();
            }
        });

        // Cách 2:
        btn_demo_butter_knife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewBinding_demo.this, "Use Butter knife", Toast.LENGTH_SHORT).show();
            }
        });

        // Cách 3: Tự động truy xuất được id
        mActivityViewBinding.btnDemoViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewBinding_demo.this, "Use ViewBinding", Toast.LENGTH_SHORT).show();
            }
        });

    }
}