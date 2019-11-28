import com.google.gson.annotations.SerializedName

/**
 * Created by khairy on ر, 22/ماي/2019 at 01:04 م.
 * mohamed.khairy@apptcom.com
 */
data class BaseResponse<T>(
    @SerializedName("businessCode") val businessCode: String,
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: T
)