package com.jet2tech.demo.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jet2tech.demo.databinding.DataItemLayoutBinding
import com.jet2tech.demo.model.ArticleItemModel
import com.jet2tech.demo.utils.getHeightforView
import com.jet2tech.demo.utils.getTimeAgo
import com.jet2tech.demo.utils.loadImage

class ArticleAdapter:RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){
    private var lstArticleItems: MutableList<ArticleItemModel> = mutableListOf()

    class ArticleViewHolder(private val binding: DataItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(it: ArticleItemModel) {
            val likeCount:Float = (it.likes.toFloat() / 1000)
            val commentCount:Float = (it.comments.toFloat() / 1000)
            binding.tvUserName.text = "${it.user[0].name} ${it.user[0].lastname}"
            binding.tvUserDesignation.text = it.user[0].designation
            binding.tvUpdationTime.text = it.createdAt.getTimeAgo()
            binding.tvArticle.text = it.content
            binding.tvLikes.text = String.format("%.1f", likeCount)+"K Likes"
            binding.tvComments.text = String.format("%.1f", commentCount)+"K Comments"
            loadImage(
                it.user[0].avatar,
                binding.ivUserImage,
                binding.root.context
            )
            if (it.media.isNotEmpty()){
                binding.layoutArticleImage.visibility = View.VISIBLE
                binding.ivArtivleImage.layoutParams.height = (binding.root.context as Activity).getHeightforView(0.3F)
                loadImage(
                    it.media[0].image,
                    binding.ivArtivleImage,
                    binding.root.context
                )
            } else {
                binding.layoutArticleImage.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            DataItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lstArticleItems.size
    }

    override fun onBindViewHolder(holderArticle: ArticleViewHolder, position: Int) {
        lstArticleItems[position].let {
            holderArticle.bind(it)
        }
    }

    public fun setItems(articleItems: MutableList<ArticleItemModel>){
        val initialSize = lstArticleItems.size
        lstArticleItems.addAll(articleItems)
        val newSize = lstArticleItems.size
        notifyItemRangeChanged(initialSize, newSize)
    }

}