package com.maturanec.recylcerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  RecyclerViewInterface{

    ArrayList<AminoAcidModel> aminoAcidModels = new ArrayList<>();
    int[] aminoAcidImages = {R.drawable.baseline_1x_mobiledata_24, R.drawable.baseline_4g_mobiledata_24,
             R.drawable.baseline_10k_24, R.drawable.baseline_10mp_24, R.drawable.baseline_10k_24, R.drawable.baseline_60fps_24, R.drawable.baseline_ac_unit_24
            , R.drawable.baseline_ac_unit_24, R.drawable.baseline_60fps_24, R.drawable.baseline_30fps_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpAminoAcidModels();

        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this, aminoAcidModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpAminoAcidModels(){
        String[] aminoAcidNames = getResources().getStringArray(R.array.amino_acids_full_txt);
        String[] aminoAcidAbbreviation = getResources().getStringArray(R.array.amino_acids_three_letter_txt);
        String[] aminoAcidAbbreviationSmall = getResources().getStringArray(R.array.amino_acids_one_letter_txt);
        for(int i = 0; i < aminoAcidNames.length; i++)
        {
            aminoAcidModels.add(new AminoAcidModel(aminoAcidNames[i], aminoAcidAbbreviation[i], aminoAcidAbbreviationSmall[i], aminoAcidImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", aminoAcidModels.get(position).getAminoAcidName());
        intent.putExtra("ABBR_BIG", aminoAcidModels.get(position).getAminoAcidAbbreviation());
        intent.putExtra("ABBR_SMALL", aminoAcidModels.get(position).getAminoAcidAbbreviationSmall());
        intent.putExtra("IMAGE", aminoAcidModels.get(position).getImage());

        startActivity(intent);

    }
}