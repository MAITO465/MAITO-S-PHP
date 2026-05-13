package com.example.maitophp.adapters;


import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.maitophp.R;
import com.example.maitophp.models.AppStudent;
import java.util.List;

public class StudentProfileAdapter extends RecyclerView.Adapter<StudentProfileAdapter.ProfileViewHolder> {
    private List<AppStudent> data;

    public StudentProfileAdapter(List<AppStudent> data) { this.data = data; }

    @NonNull @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_student_row, parent, false);
        return new ProfileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        AppStudent s = data.get(position);
        holder.name.setText(s.getNom() + " " + s.getPrenom());
        holder.info.setText(s.getVille() + " | " + s.getSexe().toUpperCase());
    }

    @Override public int getItemCount() { return data.size(); }

    static class ProfileViewHolder extends RecyclerView.ViewHolder {
        TextView name, info;
        public ProfileViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.label_name);
            info = itemView.findViewById(R.id.label_city_gender);
        }
    }
}