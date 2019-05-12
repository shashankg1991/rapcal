package com.spectra.rapcal.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.CalculatedItemsManagementActivity;
import com.spectra.rapcal.activity.RapCalculationActivity;
import com.spectra.rapcal.activity.RapManagementActivity;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.fragment.AddEditRapFragment;
import com.spectra.rapcal.fragment.ViewRapsFragment;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.entity.Stone;
import com.spectra.rapcal.persistence.service.RapService;
import com.spectra.rapcal.persistence.service.StoneService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class StoneRecylerViewAdapter extends Adapter<StoneRecylerViewAdapter.RapViewHolder> {

    List<Stone> stones;
    Context context;

    public StoneRecylerViewAdapter(List<Stone> stones, Context context) {
        this.stones = stones;
        this.context = context;
    }

    @NonNull
    @Override
    public RapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_stone_item, parent, false);
        RapViewHolder rapViewHolder = new RapViewHolder(view, context);
        return rapViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RapViewHolder holder, int position) {
        Stone stone = stones.get(position);
        holder.textViewId.setText(stone.getId().toString());
        holder.textViewShape.setText(stone.getShape());
        holder.textViewWeight.setText(stone.getWeight().toString());
        holder.textViewQuality.setText(stone.getColor() + "-" + stone.getPurity());
        holder.textViewValue.setText(stone.getValue().toString());
    }

    @Override
    public int getItemCount() {
        return null != stones ? stones.size() : 0;
    }

    //Responsible for each item in list
    public static class RapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewId, textViewQuality, textViewValue, textViewShape, textViewWeight;
        ImageButton buttonEditStone, buttonDeleteStone;
        Context context;

        public RapViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            textViewId = itemView.findViewById(R.id.recyclerview_stone_textview_id);
            textViewWeight = itemView.findViewById(R.id.recyclerview_stone_textview_weight);
            textViewShape = itemView.findViewById(R.id.recyclerview_stone_textview_shape);
            textViewQuality = itemView.findViewById(R.id.recyclerview_stone_textview_quality);
            textViewValue = itemView.findViewById(R.id.recyclerview_stone_textview_value);
            buttonEditStone = itemView.findViewById(R.id.recyclerview_stone_button_edit);
            buttonDeleteStone = itemView.findViewById(R.id.recyclerview_stone_button_delete);
            buttonEditStone.setOnClickListener(this);
            buttonDeleteStone.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Integer stoneId = Integer.valueOf(textViewId.getText().toString());
            switch (view.getId()) {
                case R.id.recyclerview_stone_button_edit:
                    Intent intentRapCalculationActivity = new Intent(context, RapCalculationActivity.class);
                    intentRapCalculationActivity.putExtra(RapCalConstants.ID, stoneId);
                    context.startActivity(intentRapCalculationActivity);
                    ((Activity)context).finish();
                    break;
                case R.id.recyclerview_stone_button_delete:
                    StoneService.getInstance().deleteStone(stoneId);
                    Intent intentCalculatedItemsManagementActivity = new Intent(context, CalculatedItemsManagementActivity.class);
                    intentCalculatedItemsManagementActivity.putExtra(RapCalConstants.ID, stoneId);
                    context.startActivity(intentCalculatedItemsManagementActivity);
                    ((Activity)context).finish();
                    break;
            }

        }
    }
}
