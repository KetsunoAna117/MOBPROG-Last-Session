package id.ac.binus.session12;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.binus.session12.model.Mahasiswa;

public class FragmentView extends Fragment {
    private ListView lvData;
    private ArrayList<Mahasiswa> mahasiswaList;
    private DatabaseHelper db;
    public FragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        lvData = view.findViewById(R.id.lvData);
        db = new DatabaseHelper(getActivity());

        updateData();
        return view;
    }

    public void updateData(){
        Cursor cursor = db.getAllData();
        mahasiswaList = new ArrayList<>();

        while(cursor.moveToNext()){
            mahasiswaList.add(new Mahasiswa(
                    cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
            ));
        }

        MahasiswaAdapter adapter = new MahasiswaAdapter(getActivity(), R.layout.activity_mahasiswa_adapter, mahasiswaList, this);
        lvData.setAdapter(adapter);
    }
}