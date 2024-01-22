package id.ac.binus.session12;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentInsert extends Fragment {
    private EditText editNim, editNama, editEmail, editPhone, editAlamat;
    private Button btnSubmit;
    private DatabaseHelper db;
    private FragmentView fragmentView;

    public FragmentInsert(FragmentView fragmentView) {
        this.fragmentView = fragmentView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        editNim = view.findViewById(R.id.edtNim);
        editNama = view.findViewById(R.id.edtNama);
        editEmail = view.findViewById(R.id.edtEmail);
        editPhone = view.findViewById(R.id.edtPhone);
        editAlamat = view.findViewById(R.id.edtAlamat);
        btnSubmit = view.findViewById(R.id.submitBtn);


        btnSubmit.setOnClickListener(event -> {
            db = new DatabaseHelper(getActivity());

            String nim = editNim.getText().toString();
            String nama = editNama.getText().toString();
            String email = editEmail.getText().toString();
            String phone = editPhone.getText().toString();
            String alamat = editAlamat.getText().toString();

            Boolean isInserted = db.isInsertedDataPerson(nim, nama, email, phone, alamat);
            if(isInserted){
                Toast.makeText(getActivity(), "Data is inserted", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getActivity(), "Data not is inserted", Toast.LENGTH_LONG).show();
            }

            fragmentView.updateData();

        });

        return view;
    }
}