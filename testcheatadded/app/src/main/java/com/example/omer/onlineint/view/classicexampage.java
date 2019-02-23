package com.example.omer.onlineint.view;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omer.onlineint.Model.ClassicExam;
import com.example.omer.onlineint.Model.Question;
import com.example.omer.onlineint.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class classicexampage extends AppCompatActivity {

    TextView questionNumber;
    TextView timer;
    TextView query;
    EditText answered;
    Button next, back;
    CountDownTimer countDownTimer;
    long timerDuration;
    String[] answers;
    int[] checked;
    ClassicExam classicExams = new ClassicExam();
    String backString = "Back", nextString = "next", Question = "Question ", finish = "Finish",classic="classic",cheatString;
    int unAnswered,duration, number, iterator = 0;
    ArrayList<Question> question=new ArrayList<>();
    String  answerHolder;

    int cheatControl;
    int counter;
    boolean cheatControlEnable=false;
    boolean cheatFlag=false;
    boolean cheat=false;

    //******************************************************************
    private TextureView textureView;

    //Check state orientation of output image
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    static{
        ORIENTATIONS.append(Surface.ROTATION_0,90);
        ORIENTATIONS.append(Surface.ROTATION_90,0);
        ORIENTATIONS.append(Surface.ROTATION_180,270);
        ORIENTATIONS.append(Surface.ROTATION_270,180);
    }

    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSessions;
    private CaptureRequest.Builder captureRequestBuilder;
    private Size imageDimension;
    private ImageReader imageReader;

    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;

    CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {
            cameraDevice = camera;
            createCameraPreview();
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            cameraDevice.close();
        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            cameraDevice=null;
        }
    };

    BitmapFactory.Options options ;
    FaceDetector faceDetector;



    //******************************************************************

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classicexam);

        answered = findViewById(R.id.ceditText);
        query = findViewById(R.id.cquery);
        next = findViewById(R.id.cnext);
        back = findViewById(R.id.cback);
        questionNumber = findViewById(R.id.cQuestionNumber);
        timer = findViewById(R.id.ctimer);
        builder = new AlertDialog.Builder(classicexampage.this);
//*********************************************

        textureView = (TextureView)findViewById(R.id.textureView1);
        assert textureView != null;
        textureView.setSurfaceTextureListener(textureListener);



        options = new BitmapFactory.Options();
        options.inMutable=true;
        faceDetector = new
                FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false)
                .build();
        //*****************************************************************

        Intent mIntent = getIntent();

        question = (ArrayList<Question>)  mIntent.getSerializableExtra("classicexam");


        duration=getIntent().getIntExtra("examduration",0);
        number=getIntent().getIntExtra("questionnumber",0);

        //  number = Integer.parseInt(classicExams.getNumber());
        timerDuration=Long.valueOf(""+duration*60*1000);

        StartTimer();

        checked= new int[number];
        answers=new String[number];




        query.setText(question.get(0).getQuest());
        next.setText(nextString);
        back.setText(backString);
        questionNumber.setText("Question 1");

        back.setVisibility(View.INVISIBLE);
        next.setVisibility(View.VISIBLE);
        iterator=0;


        for(int i=0;i<checked.length;i++){
            checked[i]=-5;
            answers[i]="null"; }}


    public void Back(View view) {

        if(!TextUtils.isEmpty(answered.getText().toString())) {
            answers[iterator]=answered.getText().toString(); }

        iterator=iterator-1;

        if (iterator == 0) {
            back.setVisibility(View.INVISIBLE);
        }


        if(answers[iterator].equals("null")){

        }
        else{
            answered.getText().clear();
            answered.setText(answers[iterator]);

            query.setText(question.get(iterator).getQuest());
            questionNumber.setText(Question + (iterator+1 ));
            next.setText(nextString);
        }
    }


    public void Next(View view) {

        if(!TextUtils.isEmpty(answered.getText().toString())){
            answers[iterator]=answered.getText().toString();
        }

        if ((number-1)==iterator) {

            setFinish();
        }

        else{
            iterator=iterator+1;
            if (iterator == (number-1)) {
                next.setText(finish); }
            answered.getText().clear();
            if(!answers[iterator].equals("null")){
                answered.setText(answers[iterator],TextView.BufferType.EDITABLE); }
            query.setText(question.get(iterator).getQuest());
            back.setVisibility(View.VISIBLE);
            questionNumber.setText(Question + (iterator + 1));

        }}








    public void StartTimer(){

        countDownTimer=new CountDownTimer(timerDuration,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                //timerDuration=millisUntilFinished;
                long secLeft =(millisUntilFinished/1000)%60;
                long minLeft=(millisUntilFinished/60)/1000;
                timer.setText(Long.toString(minLeft)+":"+Long.toString(secLeft));
                if(secLeft%5==0)  takePicture();
            }

            @Override
            public void onFinish() {

                setFinish();

            }
        }.start(); }




    void setFinish(){

        countDownTimer.cancel();
        Intent i = new Intent(this, CandidateInfo.class);
        for(int j=0;j<number;j++)
            answerHolder=answerHolder+""+i+"("+answers[j]+")";
        i.putExtra("answers",answerHolder);
        i.putExtra("examtype",classic);
        if(cheat) cheatString="cheated";
        else cheatString="notcheated";
        i.putExtra("cheat",cheatString);
        startActivity(i);
        finish();
    }



    //********************************************************************

    private void takePicture() {
        if(cameraDevice == null)
            return;
        CameraManager manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            Size[] jpegSizes = null;
            if(characteristics != null)
                jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
                        .getOutputSizes(ImageFormat.JPEG);

            //Capture image with custom size
            int width = 640;
            int height = 480;
            if(jpegSizes != null && jpegSizes.length > 0)
            {
                width = jpegSizes[0].getWidth();
                height = jpegSizes[0].getHeight();
            }
            final ImageReader reader = ImageReader.newInstance(width,height,ImageFormat.JPEG,1);
            List<Surface> outputSurface = new ArrayList<>(2);
            outputSurface.add(reader.getSurface());
            outputSurface.add(new Surface(textureView.getSurfaceTexture()));

            final CaptureRequest.Builder captureBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            captureBuilder.addTarget(reader.getSurface());
            captureBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);

            //Check orientation base on device
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            captureBuilder.set(CaptureRequest.JPEG_ORIENTATION,ORIENTATIONS.get(rotation));

            ImageReader.OnImageAvailableListener readerListener = new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader imageReader) {
                    Image image = null;
                    try{
                        image = reader.acquireLatestImage();
                        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                        byte[] bytes = new byte[buffer.capacity()];
                        buffer.get(bytes);

                        if(!faceDetector.isOperational()){
                            Log.d("vision ayarlanmadı","olmadı");
                            cheatControlEnable=false;
                        }
                        else{
                            Bitmap myBitmap=BitmapFactory.decodeByteArray(bytes, 0, bytes.length,options);
                            Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                            SparseArray<Face> faces = faceDetector.detect(frame);
                            if(faces.size()>=2 && cheatFlag) cheat=true;
                            if(faces.size()>=2)  cheatFlag=true;
                            Log.d("BULUNAN YUZ SAYISI",":"+faces.size());

                        }

                    } catch (Exception e)

                    {
                        e.printStackTrace();
                    }
                    finally {
                        {
                            if(image != null)
                                image.close();
                        }
                    }
                }

            };

            reader.setOnImageAvailableListener(readerListener,mBackgroundHandler);
            final CameraCaptureSession.CaptureCallback captureListener = new CameraCaptureSession.CaptureCallback() {
                @Override
                public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                    super.onCaptureCompleted(session, request, result);
                    createCameraPreview();
                }
            };

            cameraDevice.createCaptureSession(outputSurface, new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    try{
                        cameraCaptureSession.capture(captureBuilder.build(),captureListener,mBackgroundHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {

                }
            },mBackgroundHandler);


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void createCameraPreview() {
        try{
            SurfaceTexture texture = textureView.getSurfaceTexture();
            assert  texture != null;
            texture.setDefaultBufferSize(imageDimension.getWidth(),imageDimension.getHeight());
            Surface surface = new Surface(texture);
            captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            captureRequestBuilder.addTarget(surface);
            cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    if(cameraDevice == null)
                        return;
                    cameraCaptureSessions = cameraCaptureSession;
                    updatePreview();
                }

                @Override
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                    Toast.makeText(classicexampage.this, "Changed", Toast.LENGTH_SHORT).show();
                }
            },null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void updatePreview() {
        if(cameraDevice == null)
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE,CaptureRequest.CONTROL_MODE_AUTO);
        try{
            cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(),null,mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private void openCamera() {
        CameraManager manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            cameraId = manager.getCameraIdList()[0];
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
            StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            assert map != null;
            imageDimension = map.getOutputSizes(SurfaceTexture.class)[0];
            //Check realtime permission if run higher API 23
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },REQUEST_CAMERA_PERMISSION);
                return;
            }
            manager.openCamera(cameraId,stateCallback,null);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
            openCamera();
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CAMERA_PERMISSION)
        {
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "You can't use camera without permission", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startBackgroundThread();
        if(textureView.isAvailable())
            openCamera();
        else
            textureView.setSurfaceTextureListener(textureListener);
    }

    @Override
    protected void onPause() {
        stopBackgroundThread();
        super.onPause();


    }

    private void stopBackgroundThread() {
        mBackgroundThread.quitSafely();
        try{
            mBackgroundThread.join();
            mBackgroundThread= null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("Camera Background");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    //******************************************************************

    @Override
    public void onBackPressed() {

        if(iterator==0){
            builder.setTitle("Exam has not finished yet!");
            builder.setMessage("Press OK  to leave Exam");
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startActivity(new Intent(classicexampage.this,starterPage.class));
                    finish();
                }
            });
            builder.show();
        }

        if(iterator>1){ back.performClick(); }




    }


}