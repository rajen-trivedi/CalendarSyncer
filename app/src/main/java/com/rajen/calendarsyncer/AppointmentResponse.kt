package com.rajen.calendarsyncer

import com.google.gson.annotations.SerializedName

data class AppointmentResponse(
    @SerializedName("results") val results: List<Appointment>
)

data class Appointment(
    @SerializedName("id") val id: String,
    @SerializedName("start_date_time") val startDateTime: String,
    @SerializedName("end_date_time") val endDateTime: String,
    @SerializedName("created_by") val createdBy: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("item_id") val itemId: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("description_title") val descriptionTitle: String,
    @SerializedName("flag") val flag: String,
    @SerializedName("dealership_name") val dealershipName: String,
    @SerializedName("appointment_type") val appointmentType: String,
    @SerializedName("lead_name") val leadName: String? = null
)

