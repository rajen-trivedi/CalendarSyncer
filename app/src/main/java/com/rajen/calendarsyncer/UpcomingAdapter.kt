package com.rajen.calendarsyncer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajen.calendarsyncer.Utils.getOnlyDate
import com.rajen.calendarsyncer.Utils.getOnlyDayName
import com.rajen.calendarsyncer.Utils.time12HrFormatForCalendar
import com.rajen.calendarsyncer.databinding.RvCalendarItemBinding

class UpcomingAdapter(
    private val upComingData: MutableList<Appointment>,
) : RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    val upcomingResults: List<Appointment>
        get() = upComingData

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<Appointment>) {
        upComingData.clear()
        upComingData.addAll(newList)
        notifyDataSetChanged()
    }

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
        fun bind(value: Appointment) {
            with(binding) {
                tvDayName.text = getOnlyDayName(value.startDateTime)
                    .trim()
                tvDate.text = getOnlyDate(value.startDateTime)
                    .trim()
                tvTitle.text = value.title
                tvTime.text = time12HrFormatForCalendar(
                    upComingData[adapterPosition].startDateTime,
                    false
                ).trim()
            }
        }
    }
}