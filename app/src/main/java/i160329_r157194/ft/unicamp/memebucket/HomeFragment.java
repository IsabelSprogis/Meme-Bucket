package i160329_r157194.ft.unicamp.memebucket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    private View view;
    Button addMeme;

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflate,
                             ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflate.inflate(R.layout.fragment_home, container, false);

            addMeme = view.findViewById(R.id.addMeme);
            addMeme.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    FragmentTransaction fragmentTransaction =
                            getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, new EnviarFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
        return view;
    }
}