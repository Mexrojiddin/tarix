package uz.mexboy.hayvonlar_ekologik.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.mexboy.hayvonlar_ekologik.MainActivity;
import uz.mexboy.hayvonlar_ekologik.R;
import uz.mexboy.hayvonlar_ekologik.adapter.MundarijaAdapter;
import uz.mexboy.hayvonlar_ekologik.model.MundarijaModel;
import uz.mexboy.hayvonlar_ekologik.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("Kirish", 3));
        data.add(new MundarijaModel("Hayvonlar ekologiyasi fan sifatida", 5));
        data.add(new MundarijaModel("Autoekologiya. Hayvonlarning yashash muhitlari va\n" +
                "adaptatsiyalar", 27));
        data.add(new MundarijaModel("Abiotik omillar", 40));
        data.add(new MundarijaModel("Dunyo okeanining ekologik zonalari", 58));
        data.add(new MundarijaModel("Biotik omillar", 75));
        data.add(new MundarijaModel("Populyatsiyalar ekologiyasi", 92));
        data.add(new MundarijaModel("Biotsenoz, biogeotsenoz va ekotizimlar", 117));
        data.add(new MundarijaModel("Biosferada hayvonlarning tarqalish\n" +
                "chegaralari", 139));
        data.add(new MundarijaModel("Foydalanilgan adabiyotlar", 159));





        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}