package arsenal.metiz.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;

import java.util.List;

public class BarcodeScanActivity extends AppCompatActivity {

    private final int BARCODE_RECO_REQ_CODE = 200;
    private final int REQUEST_CODE_PERMISSION_CAMERA =150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan);

        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},
                    REQUEST_CODE_PERMISSION_CAMERA);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==BARCODE_RECO_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap)data.getExtras().get("data");
                barcodeRecognition(photo);
            }
        }
    }

    private void barcodeRecognition(Bitmap photo) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(photo);

        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
                .getVisionBarcodeDetector();

        Task<List<FirebaseVisionBarcode>> result = detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> barcodes) {
                        for (FirebaseVisionBarcode barcode: barcodes) {
                            Rect bounds = barcode.getBoundingBox();
                            Point[] corners = barcode.getCornerPoints();

                            String rawValue = barcode.getRawValue();


                            Intent intent = new Intent(BarcodeScanActivity.this,BarcodeCompActivity.class);
                            intent.putExtra("qr", rawValue);
                            startActivity(intent);
                            finish();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Intent intent = new Intent(BarcodeScanActivity.this,NotInTheBaseActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }



    public void barcodeReco(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,BARCODE_RECO_REQ_CODE);
    }
}
