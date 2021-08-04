package com.example.test.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.MainActivity;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class Image extends AppCompatActivity {
    private final int PICK_IMAGE = 1111;
    private Context mContext ;

    public Image(Context context){
        this.mContext =context;
    }


    //image를 얻기 위해서 갤러리에서 파일을 선택하고 보여주는 부분 URL도 보여줌


    public void pickFromGallery(){

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);

        startActivityForResult(intent,PICK_IMAGE);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();
            System.out.println(selectedImage);
        }
    }



    //비트맵으로 쪼개진 이미지를 전송하는 함수에 넣어주는 부분
    public String SendImg(String URL){





        return null;
    }


    //img파일을 쪼개는 부분
    public String ParseImg(){


        return null;
    }


    //img를 다시 android 환경에서 쓸 수 있게 바꾸어주는 부분
    public String reconImg(){


        return null;
    }







}
