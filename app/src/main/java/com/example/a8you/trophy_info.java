package com.example.a8you;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class trophy_info extends AppCompatActivity {

    ImageView currentBadge;
    TextView infoDetails;
    Button share;
    String badgeType;

    //    BitmapDrawable bitmapDrawable;
//    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_info);

        currentBadge = findViewById(R.id.currentBadge);
        infoDetails = findViewById(R.id.badgeDetail);
        share = findViewById(R.id.shareBadge);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            badgeType = extras.getString("badge");
//            badgeSwitch();
        }

        BitmapDrawable bitmapDrawable = (BitmapDrawable) currentBadge.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        // Sharing Badge
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareImage(badgeType, bitmap);
//                switch (badgeType) {
//                    case "newMove" :
//                        shareNewMove();
//                        break;
//                    default:
//                }
            }
        });
    }

    public String shareMessageAchieved = "The badge " + badgeType + " has been achieved";
    private void shareImage(String badgeType, Bitmap bitmap){
//        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
//        StrictMode.setVmPolicy(builder.build());

//        Uri uri = getImageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        // setting type to image
//        intent.setType("image/*");
        intent.setType("text/*");

//        Uri uri = getImageToShare(bitmap, getApplicationContext());

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // putting uri of image to be shared
//        intent.putExtra(Intent.EXTRA_STREAM, uri);

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Badge for " + badgeType + " has been achieved!");

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "8You application is sharing:");


        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);



        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    private Uri getImageToShare(Bitmap image, Context context) {
        File imagefolder = new File(context.getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "shared_images.png");

            FileOutputStream outputStream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(Objects.requireNonNull(context.getApplicationContext()) ,  "com.example.badgetest" + ".provider",file);

//            uri = FileProvider.getUriForFile(this, "${applicationId}.provider", file);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }

    // Change Image
    public void badgeSwitch(){
        ImageView currentBadge = findViewById(R.id.currentBadge);
        TextView infoDetails = findViewById(R.id.badgeDetail);
        switch (badgeType) {
            case "newMove":
                currentBadge.setImageResource(R.drawable.noclnewmove);
                break;
            default:

        }
    }


//        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
//        try {
//            f.createNewFile();
//            FileOutputStream fo = new FileOutputStream(f);
//            fo.write(bytes.toByteArray());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.jpg"));
//        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("/storage/emulated/0/Pictures/logo.png"));
//        startActivity(Intent.createChooser(shareIntent, "Share Image"));

//        shareIntent.setType("Share!");
//        startActivity(shareIntent);
}