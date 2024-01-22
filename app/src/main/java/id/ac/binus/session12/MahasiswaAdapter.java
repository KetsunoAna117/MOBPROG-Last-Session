package id.ac.binus.session12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.binus.session12.model.Mahasiswa;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {
    private Context context;
    private int resource;
    private FragmentView callback;

    public MahasiswaAdapter(@NonNull Context context, int resource, ArrayList<Mahasiswa> objects, FragmentView callback) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.callback = callback;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nim = getItem(position).getNim();
        String name = getItem(position).getName();
        String phone = getItem(position).getPhone();
        String email = getItem(position).getEmail();
        String address = getItem(position).getAlamat();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView nimTv = (TextView) convertView.findViewById(R.id.nimViewData);
        nimTv.setText(nim);

        TextView nameTv = (TextView) convertView.findViewById(R.id.namaViewData);
        nameTv.setText(name);

        TextView phoneTv = (TextView) convertView.findViewById(R.id.phoneViewData);
        phoneTv.setText(phone);

        TextView emailTv = (TextView) convertView.findViewById(R.id.emailViewData);
        emailTv.setText(email);

        TextView addressTv = (TextView) convertView.findViewById(R.id.alamatViewData);
        addressTv.setText(address);

        Button deleteBtn = (Button) convertView.findViewById(R.id.deleteButton);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(context);
                Boolean isDeleteSuccess = db.isDeletedDataPerson(getItem(position));

                if(isDeleteSuccess){
                    Toast.makeText(context, "Delete Success", Toast.LENGTH_LONG).show();
                    callback.updateData();
                }
            }
        });

        return convertView;
    }
}