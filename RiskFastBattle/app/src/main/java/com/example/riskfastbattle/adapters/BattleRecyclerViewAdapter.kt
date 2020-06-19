package com.example.riskfastbattle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.riskfastbattle.R
import com.example.riskfastbattle.models.Battle
import kotlinx.android.synthetic.main.recycler_battle_cell.view.*

class BattleRecyclerViewAdapter(var battlesArray: ArrayList<Battle>) :
    RecyclerView.Adapter<BattleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BattleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.recycler_battle_cell, parent, false)
        return BattleViewHolder(cellRow)
    }

    override fun getItemCount(): Int {
        return battlesArray.size
    }

    override fun onBindViewHolder(holder: BattleViewHolder, position: Int) {
        holder.view.recycler_cell_attacker_amount.text = battlesArray[position].attacker.toString()
        holder.view.recycler_cell_defender_amount.text = battlesArray[position].defender.toString()
    }

}


class BattleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}