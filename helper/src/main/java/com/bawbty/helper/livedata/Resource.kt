package com.bawbty.helper.livedata

data class Resource<out T>(val status: Status, val data: T?, val error: Throwable?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: Throwable, data: T?): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                error
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

        fun <T> noNetwork(): Resource<T> {
            return Resource(
                Status.NO_NETWORK,
                null,
                null
            )
        }
    }

    fun isLoading() = this.status == Status.LOADING
    fun isError() = this.status == Status.ERROR
    fun isNoNetwork() = this.status == Status.NO_NETWORK
    fun isSuccess() = this.status == Status.SUCCESS
    fun shouldBind() = this.status == Status.SUCCESS || this.status == Status.LOADING

    enum class Status {
        SUCCESS,
        ERROR,
        NO_NETWORK,
        LOADING
    }
}