package i160329_r157194.ft.unicamp.memebucket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import static i160329_r157194.ft.unicamp.memebucket.Galeria.listaMemes;

public class GaleriaFragment extends Fragment {

    private RecyclerView recyclerView;
    private GaleriaAdapter galeriaAdapter;
    private View view;


    public GaleriaFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

        if(view == null){
            view = inflater.inflate(R.layout.fragment_galeria, container, false);
        }

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        galeriaAdapter = new GaleriaAdapter(new ArrayList<Memes>(listaMemes));
        recyclerView.setAdapter(galeriaAdapter);

        return view;
    }
}