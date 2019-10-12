package com.example.daftartim.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daftartim.R
import com.example.daftartim.data.model.TeamResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*

class RvAdapter(val dataTim:List<TeamResponse.Team>)
    :RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item
                ,parent,false))
    }

    override fun getItemCount(): Int =dataTim.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(dataTim[position])

    }


    class ViewHolder(override val containerView: View)
        :RecyclerView.ViewHolder(containerView)
        ,LayoutContainer{

        fun bindData(item: TeamResponse.Team){
            tv_tim_name.text=item.strTeam
            tv__tim_stadium.text=item.strStadium
            Glide.with(containerView)
                .load(item.strTeamLogo)
                .into(iv_tim)
        }
    }
}