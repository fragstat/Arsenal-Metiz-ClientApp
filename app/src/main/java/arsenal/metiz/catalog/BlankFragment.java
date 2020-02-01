package arsenal.metiz.catalog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlankFragment extends Fragment {

    public BlankFragment() {
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
        final View rootView = inflater.inflate(R.layout.activity_list, container, false);
        final RecyclerView rv = rootView.findViewById(R.id.recycler);
        wireAdapter = new Adapter(getActivity(),fillAdapter());
        rv.setAdapter(wireAdapter);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        compReplace();
        return rootView;
    }



    public ArrayList<Composition> fillAdapter() {
         ArrayList<Composition> comp = new ArrayList<>();
        for (int i = 1; i<11; i++) {
            switch (i) {
                case 1:
                    int imageRes = R.drawable.remooved;
                    Composition composition = new Composition(imageRes,"СВ-08Г2С" ,"Проволока сварочная легированная");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-08ГСМТ","Проволока сварочная легированная" );
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-10НМА","Проволока сварочная легированная");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-18ХМА","Проволока сварочная легированная");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-08ХМФА","Проволока сварочная легированная");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-08ХГСМА","Проволока сварочная легированная");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-08ХГСМФА","Проволока сварочная легированная");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08ХН2ГМТА","Проволока сварочная легированная");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-10Х5М","Проволока сварочная легированная");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-10ГСМТ","Проволока сварочная легированная");
                    comp.add(composition9);
                    break;




            }
        }

        return comp;

    }

    public void compReplace() {
        ArrayList<Composition> comp = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            switch (i) {
                case 1:
                    int imageRes = R.drawable.remooved;
                    Composition composition = new Composition(imageRes, "СВ-08Г2С", "Проволока сварочная легированная");
                    comp.add(composition);
                    break;
                case 2:
                    int imageRes1 = R.drawable.remooved;
                    Composition composition1 = new Composition(imageRes1, "СВ-08ГСМТ", "Проволока сварочная легированная");
                    comp.add(composition1);
                    break;
                case 3:
                    int imageRes2 = R.drawable.remooved;
                    Composition composition2 = new Composition(imageRes2, "СВ-10НМА", "Проволока сварочная легированная");
                    comp.add(composition2);
                    break;
                case 4:
                    int imageRes3 = R.drawable.remooved;
                    Composition composition3 = new Composition(imageRes3, "СВ-18ХМА", "Проволока сварочная легированная");
                    comp.add(composition3);
                    break;
                case 5:
                    int imageRes4 = R.drawable.remooved;
                    Composition composition4 = new Composition(imageRes4, "СВ-08ХМФА", "Проволока сварочная легированная");
                    comp.add(composition4);
                    break;
                case 6:
                    int imageRes5 = R.drawable.remooved;
                    Composition composition5 = new Composition(imageRes5, "СВ-08ХГСМА", "Проволока сварочная легированная");
                    comp.add(composition5);
                    break;
                case 7:
                    int imageRes6 = R.drawable.remooved;
                    Composition composition6 = new Composition(imageRes6, "СВ-08ХГСМФА", "Проволока сварочная легированная");
                    comp.add(composition6);
                    break;
                case 8:
                    int imageRes7 = R.drawable.remooved;
                    Composition composition7 = new Composition(imageRes7, "СВ-08ХН2ГМТА", "Проволока сварочная легированная");
                    comp.add(composition7);
                    break;
                case 9:
                    int imageRes8 = R.drawable.remooved;
                    Composition composition8 = new Composition(imageRes8, "СВ-10Х5М", "Проволока сварочная легированная");
                    comp.add(composition8);
                    break;
                case 10:
                    int imageRes9 = R.drawable.remooved;
                    Composition composition9 = new Composition(imageRes9, "СВ-10ГСМТ", "Проволока сварочная легированная");
                    comp.add(composition9);
                    break;


            }
            wireAdapter.replaceCompositions(comp);
        }
    }


}