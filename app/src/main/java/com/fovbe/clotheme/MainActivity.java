package com.fovbe.clotheme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView clothesGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clothesGrid = (GridView) findViewById(R.id.gridClothes);
        clothesGrid.setAdapter(new ClothesImages(this));

        init();
    }

    public void init(){
        clothesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >=5){
                    String sex = "male";
                    position -= 5;
                    Intent maleIn = new Intent(MainActivity.this, Details.class);
                    maleIn.putExtra("sex", sex);
                    maleIn.putExtra("pos", position);
                    startActivity(maleIn);
                    //Toast.makeText(MainActivity.this,""+ position, Toast.LENGTH_SHORT).show();

                }
                else{
                    String sex = "female";
                    Intent femaleIn = new Intent(MainActivity.this, Details.class);
                    femaleIn.putExtra("sex", sex);
                    femaleIn.putExtra("pos", position);
                    startActivity(femaleIn);
                    //Toast.makeText(MainActivity.this,""+ position, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
