package arsenal.metiz.catalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;import java.util.ArrayList;

public class BlankFragment3 extends Fragment {

    public BlankFragment3() {
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
                    Composition composition = new Composition(imageRes,"СВ-15Х18Н12С4ТЮ" ,"ТУ 14-1-997-2012");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-12Х21Н5Т","ТУ 14-1-1464-75" );
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-10Х19Н11М4Ф","ТУ 14-1-2921-80");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-10Х14Г14Н4Т ","ТУ 14-1-2832-79");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-10ГНА","ТУ 14-130-282-96");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-10ГН1МА","ТУ 14-1-1549–76");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-08Х21Н11ФТ","ТУ 14-1-3638-83");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08Х19Н11Ф2С2","ТУ 14-1-1383-75");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-08ГСНТА","ТУ 14-130-282-96");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-08ГСНТ","ТУ 14-1-4345-2017");
                    comp.add(composition9);
                    break;
                case 11:
                    int imageRes10 = R.drawable.remooved;
                    Composition composition10 = new Composition(imageRes10, "СВ-08ГН2СМД-Ш","ТУ 14-1-4345-2017" );
                    comp.add(composition10);
                    break;
                case 12:
                    int imageRes11 = R.drawable.remooved;
                    Composition composition11 = new Composition(imageRes11, "СВ-08ГН2СМД","ТУ 14-1-4345-2017");
                    comp.add(composition11);
                    break;
                case 13:
                    int imageRes12 = R.drawable.remooved;
                    Composition composition12 = new Composition(imageRes12, "СВ-07ХН3МД","ТУ 14-1-4345-2017");
                    comp.add(composition12);
                    break;
                case 14:
                    int imageRes14 = R.drawable.remooved;
                    Composition composition14 = new Composition(imageRes14, "СВ-07Х16Н6","ТУ 14-1-997-2012");
                    comp.add(composition14);
                    break;
                case 15:
                    int imageRes15 = R.drawable.remooved;
                    Composition composition15 = new Composition(imageRes15, "СВ-04Н3ГСМТА-Ш","ТУ 14-1-4345-2017");
                    comp.add(composition15);
                    break;
                case 16:
                    int imageRes16 = R.drawable.remooved;
                    Composition composition16 = new Composition(imageRes16, "СВ-04Н3ГСМТА","ТУ 14-1-4345-2017");
                    comp.add(composition16);
                    break;
                case 17:
                    int imageRes17 = R.drawable.remooved;
                    Composition composition17 = new Composition(imageRes17, "СВ-04Н3ГМТА","ТУ 14-130-282-96");
                    comp.add(composition17);
                    break;
                case 18:
                    int imageRes18 = R.drawable.remooved;
                    Composition composition18 = new Composition(imageRes18, "СВ-03ХН3МД","ТУ 14-1-4345-2017");
                    comp.add(composition18);
                    break;
                case 19:
                    int imageRes19 = R.drawable.remooved;
                    Composition composition19 = new Composition(imageRes19, "СВ-04Х17Н10М2","ТУ 14-1-1959-77");
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
                    Composition composition = new Composition(imageRes,"СВ-15Х18Н12С4ТЮ" ,"ТУ 14-1-997-2012");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-12Х21Н5Т","ТУ 14-1-1464-75" );
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-10Х19Н11М4Ф","ТУ 14-1-2921-80");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-10Х14Г14Н4Т ","ТУ 14-1-2832-79");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-10ГНА","ТУ 14-130-282-96");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-10ГН1МА","ТУ 14-1-1549–76");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-08Х21Н11ФТ","ТУ 14-1-3638-83");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08Х19Н11Ф2С2","ТУ 14-1-1383-75");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-08ГСНТА","ТУ 14-130-282-96");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-08ГСНТ","ТУ 14-1-4345-2017");
                    comp.add(composition9);
                    break;
                case 11:
                    int imageRes10 = R.drawable.remooved;
                    Composition composition10 = new Composition(imageRes10, "СВ-08ГН2СМД-Ш","ТУ 14-1-4345-2017" );
                    comp.add(composition10);
                    break;
                case 12:
                    int imageRes11 = R.drawable.remooved;
                    Composition composition11 = new Composition(imageRes11, "СВ-08ГН2СМД","ТУ 14-1-4345-2017");
                    comp.add(composition11);
                    break;
                case 13:
                    int imageRes12 = R.drawable.remooved;
                    Composition composition12 = new Composition(imageRes12, "СВ-07ХН3МД","ТУ 14-1-4345-2017");
                    comp.add(composition12);
                    break;
                case 14:
                    int imageRes14 = R.drawable.remooved;
                    Composition composition14 = new Composition(imageRes14, "СВ-07Х16Н6","ТУ 14-1-997-2012");
                    comp.add(composition14);
                    break;
                case 15:
                    int imageRes15 = R.drawable.remooved;
                    Composition composition15 = new Composition(imageRes15, "СВ-04Н3ГСМТА-Ш","ТУ 14-1-4345-2017");
                    comp.add(composition15);
                    break;
                case 16:
                    int imageRes16 = R.drawable.remooved;
                    Composition composition16 = new Composition(imageRes16, "СВ-04Н3ГСМТА","ТУ 14-1-4345-2017");
                    comp.add(composition16);
                    break;
                case 17:
                    int imageRes17 = R.drawable.remooved;
                    Composition composition17 = new Composition(imageRes17, "СВ-04Н3ГМТА","ТУ 14-130-282-96");
                    comp.add(composition17);
                    break;
                case 18:
                    int imageRes18 = R.drawable.remooved;
                    Composition composition18 = new Composition(imageRes18, "СВ-03ХН3МД","ТУ 14-1-4345-2017");
                    comp.add(composition18);
                    break;
                case 19:
                    int imageRes19 = R.drawable.remooved;
                    Composition composition19 = new Composition(imageRes19, "СВ-04Х17Н10М2","ТУ 14-1-1959-77");
                    comp.add(composition19);
                    break;
            }
            wireAdapter.replaceCompositions(comp);
        }
    }
}