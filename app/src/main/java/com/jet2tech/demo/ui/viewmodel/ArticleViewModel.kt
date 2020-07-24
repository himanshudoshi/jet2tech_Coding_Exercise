package com.jet2tech.demo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jet2tech.demo.repository.ApiUtils
import com.jet2tech.demo.model.ArticleItemModel
import com.jet2tech.demo.repository.ErrorModel
import com.jet2tech.demo.repository.NetworkManager
import com.jet2tech.demo.repository.ServiceListener

class ArticleViewModel : ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var apiError = MutableLiveData<String>()
    var apiResponse = MutableLiveData<MutableList<ArticleItemModel>>()

    fun getItemData(page: Int, limit: Int) {
        if (isLoading.value == false) {
            isLoading.value = true

            val manager = NetworkManager()
            manager.createApiRequest(
                ApiUtils.getAPIService().getListDate(page, limit),
                object :
                    ServiceListener<MutableList<ArticleItemModel>> {
                    override fun getServerResponse(response: MutableList<ArticleItemModel>, requestcode: Int) {
                        apiResponse.value = response
                        isLoading.value = false
                    }

                    override fun getError(error: ErrorModel, requestcode: Int) {
                        apiError.value = error.error_message
                        isLoading.value = false
                    }

                })
        }
    }

}