package arsenal.metiz.catalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;import java.util.ArrayList;

public class BlankFragment2 extends Fragment {

    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Adapter wireAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_list, container, false);
        RecyclerView rv = rootView.findViewById(R.id.recycler);
        wireAdapter = new Adapter(getActivity(),fillAdapter());
        rv.setAdapter(wireAdapter);
        compReplace();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    private ArrayList<Composition> fillAdapter() {
        ArrayList<Composition> comp = new ArrayList<>();
        for (int i = 1; i<20; i++) {
            switch (i) {
                case 1:
                    int imageRes = R.drawable.remooved;
                    Composition composition = new Composition(imageRes,"СВ-12X13" ,"ГОСТ 2246-70");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-01Х19Н9","ГОСТ 2246-70" );
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-07Х18Н9ТЮ","ГОСТ 2246-70");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-06Х19Н19Т","ГОСТ 2246-70");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-04Х19Н9С2","ГОСТ 2246-70");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-08Х19Н9Ф2С2","ГОСТ 2246-70");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-07Х19Н10Б","ГОСТ 2246-70");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08Х19Н10Г2Б","ГОСТ 2246-70");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-06Х19Н10М3Т","ГОСТ 2246-70");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-08Х19Н10М3Б","ГОСТ 2246-70");
                    comp.add(composition9);
                    break;
                case 11:
                    int imageRes10 = R.drawable.remooved;
                    Composition composition10 = new Composition(imageRes10, "СВ-04Х19Н11М3","ГОСТ 2246-70" );
                    comp.add(composition10);
                    break;
                case 12:
                    int imageRes11 = R.drawable.remooved;
                    Composition composition11 = new Composition(imageRes11, "СВ-05Х20Н9ФБС","ГОСТ 2246-70");
                    comp.add(composition11);
                    break;
                case 13:
                    int imageRes12 = R.drawable.remooved;
                    Composition composition12 = new Composition(imageRes12, "СВ-06Х20Н11М3ТБ","ГОСТ 2246-70");
                    comp.add(composition12);
                    break;
                case 14:
                    int imageRes14 = R.drawable.remooved;
                    Composition composition14 = new Composition(imageRes14, "СВ-07Х25Н12Г2Т","ГОСТ 2246-70");
                    comp.add(composition14);
                    break;
                case 15:
                    int imageRes15 = R.drawable.remooved;
                    Composition composition15 = new Composition(imageRes15, "СВ-07Х25Н13","ГОСТ 2246-70");
                    comp.add(composition15);
                    break;
                case 16:
                    int imageRes16 = R.drawable.remooved;
                    Composition composition16 = new Composition(imageRes16, "СВ-08Х20Н9Г7Т","ГОСТ 2246-70");
                    comp.add(composition16);
                    break;
                case 17:
                    int imageRes17 = R.drawable.remooved;
                    Composition composition17 = new Composition(imageRes17, "СВ-08Х21Н10Г6","ГОСТ 2246-70");
                    comp.add(composition17);
                    break;
                case 18:
                    int imageRes18 = R.drawable.remooved;
                    Composition composition18 = new Composition(imageRes18, "СВ-10Х16Н25АМ6","ГОСТ 2246-70");
                    comp.add(composition18);
                    break;
                case 19:
                    int imageRes19 = R.drawable.remooved;
                    Composition composition19 = new Composition(imageRes19, "СВ-01Х23Н28М3Д3Т","ГОСТ 2246-70");
                    comp.add(composition19);
                    break;




            }
        }
        return comp;
    }

    public void compReplace() {
        ArrayList<Composition> comp = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            switch (i) {
                case 1:
                    int imageRes = R.drawable.remooved;
                    Composition composition = new Composition(imageRes,"СВ-12X13" ,"ГОСТ 2246-70");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-01Х19Н9","ГОСТ 2246-70" );
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-07Х18Н9ТЮ","ГОСТ 2246-70");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-06Х19Н9Т","ГОСТ 2246-70");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-04Х19Н9С2","ГОСТ 2246-70");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-08Х19Н9Ф2С2","ГОСТ 2246-70");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-07Х19Н10Б","ГОСТ 2246-70");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08Х19Н10Г2Б","ГОСТ 2246-70");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-06Х19Н10М3Т","ГОСТ 2246-70");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-08Х19Н10М3Б","ГОСТ 2246-70");
                    comp.add(composition9);
                    break;
                case 11:
                    int imageRes10 = R.drawable.remooved;
                    Composition composition10 = new Composition(imageRes10, "СВ-04Х19Н11М3","ГОСТ 2246-70" );
                    comp.add(composition10);
                    break;
                case 12:
                    int imageRes11 = R.drawable.remooved;
                    Composition composition11 = new Composition(imageRes11, "СВ-05Х20Н9ФБС","ГОСТ 2246-70");
                    comp.add(composition11);
                    break;
                case 13:
                    int imageRes12 = R.drawable.remooved;
                    Composition composition12 = new Composition(imageRes12, "СВ-06Х20Н11М3ТБ","ГОСТ 2246-70");
                    comp.add(composition12);
                    break;
                case 14:
                    int imageRes14 = R.drawable.remooved;
                    Composition composition14 = new Composition(imageRes14, "СВ-07Х25Н12Г2Т","ГОСТ 2246-70");
                    comp.add(composition14);
                    break;
                case 15:
                    int imageRes15 = R.drawable.remooved;
                    Composition composition15 = new Composition(imageRes15, "СВ-07Х25Н13","ГОСТ 2246-70");
                    comp.add(composition15);
                    break;
                case 16:
                    int imageRes16 = R.drawable.remooved;
                    Composition composition16 = new Composition(imageRes16, "СВ-08Х20Н9Г7Т","ГОСТ 2246-70");
                    comp.add(composition16);
                    break;
                case 17:
                    int imageRes17 = R.drawable.remooved;
                    Composition composition17 = new Composition(imageRes17, "СВ-08Х21Н10Г6","ГОСТ 2246-70");
                    comp.add(composition17);
                    break;
                case 18:
                    int imageRes18 = R.drawable.remooved;
                    Composition composition18 = new Composition(imageRes18, "СВ-10Х16Н25АМ6","ГОСТ 2246-70");
                    comp.add(composition18);
                    break;
                case 19:
                    int imageRes19 = R.drawable.remooved;
                    Composition composition19 = new Composition(imageRes19, "СВ-01Х23Н28М3Д3Т","ГОСТ 2246-70");
                    comp.add(composition19);
                    break;

            }
            wireAdapter.replaceCompositions(comp);
        }
    }

}