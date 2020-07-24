package com.jet2tech.demo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jet2tech.demo.R
import com.jet2tech.demo.databinding.ActivityMainBinding
import com.jet2tech.demo.model.ArticleItemModel
import com.jet2tech.demo.ui.adapter.ArticleAdapter
import com.jet2tech.demo.ui.viewmodel.ArticleViewModel
import com.jet2tech.demo.utils.Pagination

class ArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter

    private var page = 1
    private var limit = 10
    private var isLastPage = false
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ArticleViewModel()
        viewModel.isLoading.value = false



        initItems()
        attachObserver()

    }

    private fun initItems() {

        binding.tvNoDataAvailable.visibility = View.VISIBLE
        binding.rvItems.visibility = View.GONE

        articleAdapter = ArticleAdapter()
        val layoutManager = LinearLayoutManager(this@ArticleActivity)
        binding.rvItems.apply {
            this.layoutManager = layoutManager
            this.adapter = articleAdapter
            this.addOnScrollListener(object : Pagination(layoutManager){
                override fun loadMoreItems() {
                    isLoading = true
                    page++
                    viewModel.getItemData(page, limit)
                }

                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

            })
        }


        viewModel.getItemData(page, limit)
    }

    private fun attachObserver() {
        viewModel.apiResponse.observe(this@ArticleActivity, Observer {
            it.let {
                if (it is MutableList<ArticleItemModel>) {
                    binding.tvNoDataAvailable.visibility = View.GONE
                    binding.rvItems.visibility = View.VISIBLE
                    articleAdapter.setItems(it)
                }
            }
        })
    }
}
