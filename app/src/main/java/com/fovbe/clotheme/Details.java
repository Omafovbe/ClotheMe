package com.fovbe.clotheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    ImageView imgView;
    public String[] mclothes, fclothes;
    public String dsex; int dpos;
    public int view ;
    EditText shoulder, sleeve, chest, waist, thighs, rLaps, rKnee, rAnckle, tLength, sLength;
    EditText name, address, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mclothes = getResources().getStringArray(R.array.maleClothes);
        fclothes = getResources().getStringArray(R.array.femaleClothes);
        dsex = getIntent().getExtras().getString("sex");
        dpos = getIntent().getExtras().getInt("pos");






        if(dsex.equals("male")){
            Toast.makeText(this, dsex, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.male);

            return;
        }

        setContentView(R.layout.female);
        imgView = (ImageView) findViewById(R.id.mimgFile);
        //imgView.setImageDrawable(R.drawable);

    }

    public void maleSubmit(View v){
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phoneno);

        shoulder = (EditText) findViewById(R.id.mshoulder);
        sleeve  = (EditText) findViewById(R.id.msleeve);
        chest = (EditText) findViewById(R.id.chest);
        waist = (EditText) findViewById(R.id.mwaist);
        thighs = (EditText) findViewById(R.id.thigh);
        rLaps = (EditText) findViewById(R.id.rlaps);
        rKnee = (EditText) findViewById(R.id.knee);
        rAnckle = (EditText) findViewById(R.id.ankle);
        tLength = (EditText) findViewById(R.id.tlength);
        sLength = (EditText) findViewById(R.id.slength);
        String[] contacts = {"i.omafovbe@gmail.com"};
        String msg;
        msg = "Here is the details for sewing\n";
        msg += name.getText().toString() + " \n";
        msg += address.getText().toString() + " \n";
        msg += phone.getText().toString() + " \n";
        msg += sleeve.getText().toString() + " \n";
        msg += chest.getText().toString() + " \n";
        msg += waist.getText().toString() + " \n";
        msg += thighs.getText().toString() + " \n";
        msg += rLaps.getText().toString() + " \n";
        msg += rKnee.getText().toString() + " \n";
        msg += rAnckle.getText().toString() + " \n";
        msg += tLength.getText().toString() + " \n";
        msg += sLength.getText().toString() + " \n";



        Intent informTailor = new Intent(Intent.ACTION_SENDTO);
        informTailor.setData(Uri.parse("mailto:"));
        informTailor.putExtra(Intent.EXTRA_EMAIL, contacts);
        informTailor.putExtra(Intent.EXTRA_SUBJECT, "Please sew for me");
        informTailor.putExtra(Intent.EXTRA_TEXT, msg);
        if (informTailor.resolveActivity(getPackageManager()) != null) {
            startActivity(informTailor);
        }
    }
}
