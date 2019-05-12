package com.spectra.rapcal.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.activity.RapManagementActivity;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.fragment.AddEditRapFragment;
import com.spectra.rapcal.fragment.LoginFragment;
import com.spectra.rapcal.fragment.ViewRapsFragment;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.service.RapService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class RapRecylerViewAdapter extends Adapter<RapRecylerViewAdapter.RapViewHolder> {

    List<Rap> raps;

    public RapRecylerViewAdapter(List<Rap> raps) {
        this.raps = raps;
    }

    @NonNull
    @Override
    public RapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_rap_item, parent, false);
        RapViewHolder rapViewHolder = new RapViewHolder(view);
        return rapViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RapViewHolder holder, int position) {
        Rap rap = raps.get(position);
        holder.textViewId.setText("ID : " + rap.getId());
        holder.textViewRapValue.setText("Rap : $" + rap.getValue());
        holder.textViewShape.setText("Shape : " + rap.getShape());
        holder.textViewColorPurity.setText("Quality : " + rap.getColor() + " " + rap.getPurity());
        holder.textViewRange.setText("Weight Range : " + rap.getFromWeight() + " - " + rap.getToWeight());
    }

    @Override
    public int getItemCount() {
        return null != raps ? raps.size() : 0;
    }

    //Responsible for each item in list
    public static class RapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewId, textViewShape, textViewColorPurity, textViewRapValue, textViewRange;
        Button buttonEditRap, buttonDeleteRap;

        public RapViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.recyclerview_rap_textview_id);
            textViewShape = itemView.findViewById(R.id.recyclerview_rap_textview_shape);
            textViewColorPurity = itemView.findViewById(R.id.recyclerview_rap_textview_colorPurity);
            textViewRapValue = itemView.findViewById(R.id.recyclerview_rap_textview_value);
            textViewRange = itemView.findViewById(R.id.recyclerview_rap_textview_range);
            buttonEditRap = itemView.findViewById(R.id.recyclerview_rap_button_edit);
            buttonDeleteRap = itemView.findViewById(R.id.recyclerview_rap_button_delete);
            buttonEditRap.setOnClickListener(this);
            buttonDeleteRap.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Integer rapId = Integer.valueOf(textViewId.getText().toString().split(":")[1].trim());
            switch (view.getId()) {
                case R.id.recyclerview_rap_button_edit:
                    Fragment addEditRapFragment = new AddEditRapFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(RapCalConstants.ID, rapId);
                    addEditRapFragment.setArguments(bundle);
                    RapManagementActivity.fragmentManager
                            .beginTransaction()
                            .replace(R.id.activity_rap_management_fragment_container, addEditRapFragment)
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.recyclerview_rap_button_delete:
                    RapService.getInstance().deleteRap(rapId);
                    RapManagementActivity.fragmentManager
                            .beginTransaction()
                            .replace(R.id.activity_rap_management_fragment_container, new ViewRapsFragment())
                            .addToBackStack(null)
                            .commit();
                    break;

            }
        }
    }
}
