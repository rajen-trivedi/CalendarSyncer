package com.rajen.calendarsyncer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajen.calendarsyncer.databinding.RvCalendarItemBinding

class UpcomingAdapter(
    val context: Context,
    private val upComingData: MutableList<String>,
) : RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    val upcomingResults: List<String>
        get() = upComingData

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpcomingAdapter.UpcomingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvCalendarItemBinding.inflate(inflater, parent, false)
        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingAdapter.UpcomingViewHolder, position: Int) {
        holder.bind(upComingData[position])
    }

    override fun getItemCount(): Int = upcomingResults.size

    inner class UpcomingViewHolder(private val binding: RvCalendarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(value: String) {

        }
    }
}