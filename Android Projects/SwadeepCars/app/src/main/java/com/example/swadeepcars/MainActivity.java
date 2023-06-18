package com.example.swadeepcars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> childItem;
    Map<String,List<String>> listHashmap;

    List<String> parentItem = new ArrayList<>() ;

    {
        parentItem.add("HatchBack");
        parentItem.add("mini-SUV");
        parentItem.add("Sedan");
        parentItem.add("SUV");
        parentItem.add("Coupe");
    }

    String[] hatchback = {
            "i10","Alto","Kwid","Tiago","Indica","Figo"
    };

    String[] minisuv = {
            "Nexon","Breeza","Venue","Ecosport","Sonet","XUV-300/400"
    };

    String[] sedan = {
            "Swift Dzire","Tigor","Ciaz","Aura","Verna","Amaze"
    };

    String[] suv = {
            "Fortuner","XUV-500/700","Bolero","Endeavour","Safari","Defender"
    };

    String[] coupe = {
            "Mustang","Aventador","Huracan","GLC Coupe","Volvo Concept","Audi TT"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandableListView);
        listHashmap = new LinkedHashMap<>();
        for (String HoldItem:parentItem)
        {
            if (HoldItem.equals("HatchBack"))
            {
                loadChild(hatchback);
            }
            else if (HoldItem.equals("mini-SUV"))
            {
                loadChild(minisuv);
            }
            else if (HoldItem.equals("Sedan"))
            {
            loadChild(sedan);
            }
            else if (HoldItem.equals("SUV"))
            {
                loadChild(suv);
            }
            else if (HoldItem.equals("Coupe"))
            {
                loadChild(coupe);
            }


            listHashmap.put(HoldItem,childItem);

        }

        ExpandableListAdapter adapter = new MainAdapter(this,parentItem,(HashMap<String, List<String>>)listHashmap);
        expandableListView.setAdapter(adapter);

    }

    private void loadChild(String[] parentElementName)
    {
        childItem = new ArrayList<>();
        Collections.addAll(childItem,parentElementName);
    }

}