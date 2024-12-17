package com.example.kiddosafecard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    // Member variables
    private Context context;
    private ArrayList<User> userArrayList;

    // Constructor
    public MyAdapter2(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom layout for each item
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the views
        User user = userArrayList.get(position);
        holder.childName.setText(user.getChildName());
        holder.vaccination.setText(user.getVaccination());
        holder.remarks.setText(user.getRemarks());

        // Set the OnClickListener for the button
        holder.viewDetailsButton.setOnClickListener(v -> {
            // Example: Show a toast message
            Toast.makeText(context, "Details for: " + user.getChildName(), Toast.LENGTH_SHORT).show();

            // Or start a new activity
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("childName", user.getChildName());
            intent.putExtra("vaccination", user.getVaccination());
            intent.putExtra("remarks", user.getRemarks());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        // Return the size of the dataset
        return userArrayList.size();
    }

    // ViewHolder class with Button added
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView childName, vaccination, remarks;
        Button viewDetailsButton; // New button field

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the TextViews
            childName = itemView.findViewById(R.id.tvChildName);
            vaccination = itemView.findViewById(R.id.tvVaccinationName);
            remarks = itemView.findViewById(R.id.tvRemarks);
            // Initialize the Button
            viewDetailsButton = itemView.findViewById(R.id.btnViewDetails);
        }
    }
}
