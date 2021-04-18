package com.example.example2


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_driver_layout.view.*




   // There are two types of values in constructor which are used in code below.
class DriverAdapter(private val context: Context,
                    private val items: List<DriverModelClass>)
    : RecyclerView.Adapter<DriverAdapter.ViewHolder>() {


    // Item views designed in xml layout file is inflated by LayoutInflater.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_driver_layout, parent, false)
        )
    }

    /*
     Each item is binded in the ArrayList to a view called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     This new ViewHolder should be constructed with a new View that can represent the items of the given type.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.dName.text = item.name
        holder.dTeam.text = item.team
        holder.dCountry.text = item.country
        holder.dPodiums.text = item.podiums.toString()
        holder.dPoints.text = item.points.toString()
        holder.dGrandPrixEntered.text = item.grand_prix_entered.toString()
        holder.dWorldChampionship.text = item.world_championships.toString()
        holder.dHighestGridPosition.text = item.highest_grid_position.toString()
        holder.dDate.text = item.birth.date
        holder.dPlace.text = item.birth.place

        // To do the same thing with image I used Glide library

        Glide.with(holder.dImage)
                .load(item.image)
                .into(holder.dImage)

    }

       //Gets the number of items in the list

    override fun getItemCount(): Int {
        return items.size
    }

       /*
         ViewHolder is created and initializes some private fields to be used by RecyclerView.
         A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Holds the TextView that will add each item to

        val dImage = view.image
        val dName = view.name
        val dTeam = view.team
        val dCountry = view.country
        val dPodiums = view.podiums
        val dPoints = view.points
        val dGrandPrixEntered = view.grand_prix_entered
        val dWorldChampionship = view.world_championships
        val dHighestGridPosition = view.highest_grid_position
        val dDate = view.date_of_birth
        val dPlace = view.place_of_birth

    }
}