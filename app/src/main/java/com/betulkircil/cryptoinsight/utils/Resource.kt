package com.betulkircil.cryptoinsight.utils

import com.betulkircil.cryptoinsight.domain.model.NewsModel

sealed class Resource<T>(val data: T? = null, val message:String? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data:T? = null) : Resource<T>(data = data,message=message)
    class Loading<T>(data:T?= null) : Resource<T>(data=data), List<NewsModel> {
        override val size: Int
            get() = TODO("Not yet implemented")

        override fun contains(element: NewsModel): Boolean {
            TODO("Not yet implemented")
        }

        override fun containsAll(elements: Collection<NewsModel>): Boolean {
            TODO("Not yet implemented")
        }

        override fun get(index: Int): NewsModel {
            TODO("Not yet implemented")
        }

        override fun indexOf(element: NewsModel): Int {
            TODO("Not yet implemented")
        }

        override fun isEmpty(): Boolean {
            TODO("Not yet implemented")
        }

        override fun iterator(): Iterator<NewsModel> {
            TODO("Not yet implemented")
        }

        override fun lastIndexOf(element: NewsModel): Int {
            TODO("Not yet implemented")
        }

        override fun listIterator(): ListIterator<NewsModel> {
            TODO("Not yet implemented")
        }

        override fun listIterator(index: Int): ListIterator<NewsModel> {
            TODO("Not yet implemented")
        }

        override fun subList(fromIndex: Int, toIndex: Int): List<NewsModel> {
            TODO("Not yet implemented")
        }
    }
}