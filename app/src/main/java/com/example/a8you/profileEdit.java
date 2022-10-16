package com.example.a8you;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.*;
import com.google.firebase.storage.FirebaseStorage;
import com.paypal.android.sdk.e;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
//
//import static io.grpc.Context.LazyStorage.storage;

public class profileEdit extends AppCompatActivity  {

//    private EditText name, weight, height, age;
//    private TextView saveEdit;
//    private Button mSaveBtn ;
//    private RadioGroup radiogroup;
//    private RadioButton maleBn, femaleBtn;
//    User.genderEnum gender;
//
//    // views for button
//    private Button btnSelect, btnUpload;
////    // view for image view
//    private ImageView imageView;
////
//    // Uri indicates, where the image will be picked from
//    private Uri filePath;
////
////    // request code
//    private final int PICK_IMAGE_REQUEST = 22;
//
//    // Database Reference for Firebase.
//    private DatabaseReference mDatabase;
//    private StorageReference storageReference;
//    FirebaseStorage storage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        mSaveBtn =(Button)findViewById(R.id.saveEdit);
//        name =(EditText) findViewById(R.id.name2);
//        weight =(EditText) findViewById(R.id.weight2);
//        height =(EditText) findViewById(R.id.height2);
//        age =(EditText) findViewById(R.id.age2);
//
//        radiogroup= findViewById(R.id.radioGroup);
//
////        storageReference = FirebaseStorage.getInstance().getReference("");
////        mDatabase = FirebaseDatabase.getInstance().getReference("");
//
//       radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(RadioGroup radioGroup, int i) {
//               RadioButton radioButton =findViewById(i);
//               Toast.makeText(profileEdit.this, "selected gender" + radioButton.getText(), Toast.LENGTH_SHORT).show();
//           }
//       });
//        // initialise views
//
//        btnSelect = findViewById(R.id.btnChoose);
//        btnUpload = findViewById(R.id.btnUpload);
//        imageView = findViewById(R.id.imgView);
//
//        // get the Firebase  storage reference
//        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference();
//
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        // on pressing btnSelect SelectImage() is called
//        btnSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SelectImage();
//            }
//        });
//
//        // on pressing btnUpload uploadImage() is called
//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                uploadImage();
//            }
//        });
//
//        mSaveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String name1 = name.getText().toString().trim();
//                String height1 = height.getText().toString().trim();
//                String weight1 = weight.getText().toString().trim();
//                String age1 = age.getText().toString().trim();
//
//                HashMap<String, String> dataMap = new HashMap<String, String>();
//                dataMap.put("Name", name1);
//                dataMap.put("height", height1);
//                dataMap.put("weight", weight1);
//                dataMap.put("age", age1);
//
//                mDatabase.push().setValue(dataMap);
////                mDatabase.push().setValue(height1);
////                mDatabase.push().setValue(weight1);
////                mDatabase.push().setValue(age1);
//
//            }
//
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                if (task.isSuccessful()){
//                    User user = new User(name, age, weight, height);
//
//                    FirebaseDatabase.getInstance().getReference("Users")
//                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid());}}
//
//        });
//
//    }
//    // Select Image method
//    private void SelectImage()
//    {
//
//        // Defining Implicit Intent to mobile gallery
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(
//                Intent.createChooser(
//                        intent,
//                        "Select Image from here..."),
//                PICK_IMAGE_REQUEST);
//    }
//
//    // Override onActivityResult method
//    @Override
//    protected void onActivityResult(int requestCode,
//                                    int resultCode,
//                                    Intent data)
//    {
//
//        super.onActivityResult(requestCode,
//                resultCode,
//                data);
//
//        // checking request code and result code
//        // if request code is PICK_IMAGE_REQUEST and
//        // resultCode is RESULT_OK
//        // then set image in the image view
//        if (requestCode == PICK_IMAGE_REQUEST
//                && resultCode == RESULT_OK
//                && data != null
//                && data.getData() != null) {
//
//            // Get the Uri of data
//            filePath = data.getData();
//            try {
//
//                // Setting image on image view using Bitmap
//                Bitmap bitmap = MediaStore
//                        .Images
//                        .Media
//                        .getBitmap(
//                                getContentResolver(),
//                                filePath);
//                imageView.setImageBitmap(bitmap);
//            }
//
//            catch (IOException e) {
//                // Log the exception
//                e.printStackTrace();
//            }
//        }
//    }
//    // UploadImage method
//    private void uploadImage()
//    {
//        if (filePath != null) {
//
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
//
//            // Code for showing progressDialog while uploading
//            ProgressDialog progressDialog
//                    = new ProgressDialog(this);
//            progressDialog.setTitle("Uploading...");
//            progressDialog.show();
//
//            // Defining the child of storageReference
//            StorageReference ref
//                    = storageReference
//                    .child(user.getUid())
//                    .child(
//                            "images/"
//                                    + UUID.randomUUID().toString()+getFileExtension(filePath));
//
//            // adding listeners on upload
//            // or failure of image
//            ref.putFile(filePath)
//                    .addOnSuccessListener(
//                            new OnSuccessListener<UploadTask.TaskSnapshot>() {
//
//                                @Override
//                                public void onSuccess(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//
//                                    // Image uploaded successfully
//                                    // Dismiss dialog
//                                    progressDialog.dismiss();
//                                    Toast
//                                            .makeText(profileEdit.this,
//                                                    "Image Uploaded!!",
//                                                    Toast.LENGTH_SHORT)
//                                            .show();
//////                                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//////                                        @Override
//////                                        public void onSuccess(Uri uri) {
//////                                            Uri downloadUrl = uri;
//////                                            Toast.makeText(profileEdit.this, "Upload success! URL - " + downloadUrl.toString() , Toast.LENGTH_SHORT).show();
//////                                        }
////                                    });
////                                     Upload upload = new Upload(taskSnapshot.getDownoadUrl().toString());
////                                    String uploadId = storageReference.push().getKey();
////                                    storageReference.child(uploadId).setValue(upload);
//                                }
//                            })
//
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e)
//                        {
//
//                            // Error, Image not uploaded
//                            progressDialog.dismiss();
//                            Toast
//                                    .makeText(profileEdit.this,
//                                            "Failed " + e.getMessage(),
//                                            Toast.LENGTH_SHORT)
//                                    .show();
//                        }
//                    })
//                    .addOnProgressListener(
//                            new OnProgressListener<UploadTask.TaskSnapshot>() {
//
//                                // Progress Listener for loading
//                                // percentage on the dialog box
//                                @Override
//                                public void onProgress(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//                                    double progress
//                                            = (100.0
//                                            * taskSnapshot.getBytesTransferred()
//                                            / taskSnapshot.getTotalByteCount());
//                                    progressDialog.setMessage(
//                                            "Uploaded "
//                                                    + (int)progress + "%");
//                                }
//                            });
//        }}
//
//    private String getFileExtension(Uri uri){
//        ContentResolver cR = getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(cR.getType(uri)) ;
    }


//    // UploadImage method
//    private void uploadImage()
//    {
//        if (filePath != null) {
//
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
//
//            // Code for showing progressDialog while uploading
//            ProgressDialog progressDialog
//                    = new ProgressDialog(this);
//            progressDialog.setTitle("Uploading...");
//            progressDialog.show();
//
//            // Defining the child of storageReference
//            StorageReference ref
//                    = storageReference
//                    .child(user.getUid())
//                    .child(
//                            "images/"
//                                    + UUID.randomUUID().toString()+getFileExtension(filePath));
//
//            // adding listeners on upload
//            // or failure of image
//            ref.putFile(filePath)
//                    .addOnSuccessListener(
//                            new OnSuccessListener<UploadTask.TaskSnapshot>() {
//
//                                @Override
//                                public void onSuccess(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//
//                                    // Image uploaded successfully
//                                    // Dismiss dialog
//                                    progressDialog.dismiss();
////                                    Toast
////                                            .makeText(profileEdit.this,
////                                                    "Image Uploaded!!",
////                                                    Toast.LENGTH_SHORT)
////                                            .show();
//                                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                        @Override
//                                        public void onSuccess(Uri uri) {
//                                            Uri downloadUrl = uri;
//                                            Toast.makeText(profileEdit.this, "Upload success! URL - " + downloadUrl.toString() , Toast.LENGTH_SHORT).show();
//                                        }
//                                    });
////                                     Upload upload = new Upload(taskSnapshot.getDownoadUrl().toString());
////                                    String uploadId = storageReference.push().getKey();
////                                    storageReference.child(uploadId).setValue(upload);
//                                }
//                            })
//
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e)
//                        {
//
//                            // Error, Image not uploaded
//                            progressDialog.dismiss();
//                            Toast
//                                    .makeText(profileEdit.this,
//                                            "Failed " + e.getMessage(),
//                                            Toast.LENGTH_SHORT)
//                                    .show();
//                        }
//                    })
//                    .addOnProgressListener(
//                            new OnProgressListener<UploadTask.TaskSnapshot>() {
//
//                                // Progress Listener for loading
//                                // percentage on the dialog box
//                                @Override
//                                public void onProgress(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//                                    double progress
//                                            = (100.0
//                                            * taskSnapshot.getBytesTransferred()
//                                            / taskSnapshot.getTotalByteCount());
//                                    progressDialog.setMessage(
//                                            "Uploaded "
//                                                    + (int)progress + "%");
//                                }
//                            });
//        }
    }


   // @Override
//    public void onClick(View view) {
//        startActivity(new Intent(this, Profile.class));
//    }
//
//    private void saveEdit(){
//        String name1 = name.getText().toString().trim();
//        String weight1 = weight.getText().toString().trim();
//        String height1 = height.getText().toString().trim();
//        String age1 = age.getText().toString().trim();
//    }
//    mAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//    User1 user1 = new User1(name, weight, height, age);
//
//    FirebaseDatabase.getInstance().getReference("Users1")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//            .setValue(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
//
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//
//                }
//            });
    // views for button
//    private Button btnSelect, btnUpload;
//    // view for image view
//    private ImageView imageView;
//
//    // Uri indicates, where the image will be picked from
//    private Uri filePath;
//
//    // request code
//    private final int PICK_IMAGE_REQUEST = 22;
//
//    private TextView test;
//    private Button saveEdit;
//    private EditText editName, editOldEmail, editNewEmail, editWeight, editHeight, editAge, editOldPassword, editNewPassword;
//    private FirebaseAuth mAuth;
//    private DatabaseReference mDatabase;
//    User.genderEnum gender;
//
//    // instance for firebase storage and StorageReference
//    FirebaseStorage storage;
//    StorageReference storageReference;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile_edit);
//
//        mAuth = FirebaseAuth.getInstance();
////        mDatabase = FirebaseDatabase.getInstance().getReference();
//
////        editOldEmail = (EditText) findViewById(R.id.oldEmail);
////        editNewEmail = (EditText) findViewById(R.id.newEmail);
//
//
////        editOldPassword = (EditText) findViewById(R.id.oldPassword);
////        editNewPassword = (EditText) findViewById(R.id.newPassword);
////
//        ActionBar actionBar;
//        actionBar = getSupportActionBar();
//        ColorDrawable colorDrawable
//                = new ColorDrawable(
//                Color.parseColor("#0F9D58"));
//        actionBar.setBackgroundDrawable(colorDrawable);
//
//        // initialise views
//
//        btnSelect = findViewById(R.id.btnChoose);
//        btnUpload = findViewById(R.id.btnUpload);
//        imageView = findViewById(R.id.imgView);
//
//        // get the Firebase  storage reference
//        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference();
//
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        // on pressing btnSelect SelectImage() is called
//        btnSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SelectImage();
//            }
//        });
//
//        // on pressing btnUpload uploadImage() is called
//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                uploadImage();
//            }
//        });
//
//    }
//    // Select Image method
//    private void SelectImage()
//    {
//
//        // Defining Implicit Intent to mobile gallery
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(
//                Intent.createChooser(
//                        intent,
//                        "Select Image from here..."),
//                PICK_IMAGE_REQUEST);
//    }
//
//    // Override onActivityResult method
//    @Override
//    protected void onActivityResult(int requestCode,
//                                    int resultCode,
//                                    Intent data)
//    {
//
//        super.onActivityResult(requestCode,
//                resultCode,
//                data);
//
//        // checking request code and result code
//        // if request code is PICK_IMAGE_REQUEST and
//        // resultCode is RESULT_OK
//        // then set image in the image view
//        if (requestCode == PICK_IMAGE_REQUEST
//                && resultCode == RESULT_OK
//                && data != null
//                && data.getData() != null) {
//
//            // Get the Uri of data
//            filePath = data.getData();
//            try {
//
//                // Setting image on image view using Bitmap
//                Bitmap bitmap = MediaStore
//                        .Images
//                        .Media
//                        .getBitmap(
//                                getContentResolver(),
//                                filePath);
//                imageView.setImageBitmap(bitmap);
//            }
//
//            catch (IOException e) {
//                // Log the exception
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // UploadImage method
//    private void uploadImage()
//    {
//        if (filePath != null) {
//
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//            // Code for showing progressDialog while uploading
//            ProgressDialog progressDialog
//                    = new ProgressDialog(this);
//            progressDialog.setTitle("Uploading...");
//            progressDialog.show();
//
//            // Defining the child of storageReference
//            StorageReference ref
//                    = storageReference
//                    .child(user.getUid())
//                    .child(
//                            "images/"
//                                    + UUID.randomUUID().toString());
//
//            // adding listeners on upload
//            // or failure of image
//            ref.putFile(filePath)
//                    .addOnSuccessListener(
//                            new OnSuccessListener<UploadTask.TaskSnapshot>() {
//
//                                @Override
//                                public void onSuccess(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//
//                                    // Image uploaded successfully
//                                    // Dismiss dialog
//                                    progressDialog.dismiss();
//                                    Toast
//                                            .makeText(profileEdit.this,
//                                                    "Image Uploaded!!",
//                                                    Toast.LENGTH_SHORT)
//                                            .show();
//                                }
//                            })
//
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e)
//                        {
//
//                            // Error, Image not uploaded
//                            progressDialog.dismiss();
//                            Toast
//                                    .makeText(profileEdit.this,
//                                            "Failed " + e.getMessage(),
//                                            Toast.LENGTH_SHORT)
//                                    .show();
//                        }
//                    })
//                    .addOnProgressListener(
//                            new OnProgressListener<UploadTask.TaskSnapshot>() {
//
//                                // Progress Listener for loading
//                                // percentage on the dialog box
//                                @Override
//                                public void onProgress(
//                                        UploadTask.TaskSnapshot taskSnapshot)
//                                {
//                                    double progress
//                                            = (100.0
//                                            * taskSnapshot.getBytesTransferred()
//                                            / taskSnapshot.getTotalByteCount());
//                                    progressDialog.setMessage(
//                                            "Uploaded "
//                                                    + (int)progress + "%");
//                                }
//                            });
//        }
//    }
//
//
//
////    public boolean saveAdd(View view){
////        test = (TextView) findViewById(R.id.test);
////        mDatabase = FirebaseDatabase.getInstance().getReference();
////        editName = findViewById(R.id.name);
////        editWeight = findViewById(R.id.weight);
////        editHeight = findViewById(R.id.height);
////        editAge =  findViewById(R.id.age);
//
//        String username = editName.getText().toString().trim();
//        String height = editHeight.getText().toString().trim();
//        String weight = editWeight.getText().toString().trim();
//        String age = editAge.getText().toString().trim();
//
//
////        if (username.isEmpty()){
////            editName.setError("Error");
////            return false;
////        }
//        User user = new User(height,weight,age);
////        test.setText(height);
////        FirebaseDatabase.getInstance().getReference("Users")
////                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
////                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
////            @Override
////            public void onComplete(@NonNull Task<Void> task) {
////                if(task.isSuccessful()){
////                    Toast.makeText(profileEdit.this, "Data has been Stored",
////                            Toast.LENGTH_LONG).show();
////                    test.setText("Works!");
//////                    Log.d("app","data inserted");
////                } else {
////                    Toast.makeText(profileEdit.this, "An Error Has Been Occured",
////                            Toast.LENGTH_SHORT).show();
////                    Log.d("app","FAIL ADD");
////                }
//            }
//        });


//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                mDatabase.setValue(username);
//                // after adding this data we are showing toast message.
//                Toast.makeText(profileEdit.this, "data added", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(profileEdit.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
//
//            }
//        });



        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.maleBtn:
//                if (checked)
//                    gender = User.genderEnum.MALE;
//                    break;
//            case R.id.femaleBtn:
//                if (checked)
//                    gender = User.genderEnum.FEMALE;
//                    break;
//        }
//        User user1 = new User(username, height, weight,age);
////        mDatabase.child( FirebaseAuth.getInstance().getCurrentUser().getUid() ).setValue(username);
//        mDatabase.push().setValue(username).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(profileEdit.this, "Data has been Stored",
//                            Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(profileEdit  .this, "An Error Has Been Occured",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        return true;
//    }
//    public static String getMyData(String s) {
//        String myString = s;
//        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
//        switch (s){
//            case("gender"):
//                myString = sharedPreferences.getString("gender", null);
//                break;
//            case("age"):
//                myString = sharedPreferences.getString("age", null);
//                break;
//            case("weight"):
//                myString = sharedPreferences.getString("weight", null);
//                break;
//            case("height"):
//                myString = sharedPreferences.getString("height", null);
//                break;
//        }
//
//        return myString;


