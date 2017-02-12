package com.ivoryartwork.squirrel.activity;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ivoryartwork.squirrel.R;

public class CameraLightActivity extends AppCompatActivity {

    private Button openLight;
    private Camera camera;
    private boolean isopent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_light);
        openLight = (Button) findViewById(R.id.openLight);
        openLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isopent) {
                    openLight.setText("关闭");
                    camera = Camera.open();
                    Camera.Parameters params = camera.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(params);
                    camera.startPreview(); // 开始亮灯
                    isopent = true;
                } else {
                    openLight.setText("打开");
                    camera.stopPreview(); // 关掉亮灯
                    camera.release(); // 关掉照相机
                    isopent = false;
                }

            }
        });
    }
}
