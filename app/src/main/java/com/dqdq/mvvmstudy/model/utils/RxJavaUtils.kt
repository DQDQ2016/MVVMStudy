package com.dqdq.mvvmstudy.model.utils

import io.reactivex.Flowable
import io.reactivex.MaybeTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function

import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit


object RxJavaUtils {

    fun <T> observerToMain():ObservableTransformer<T,T>{
        return ObservableTransformer {
            upstream ->
            upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> maybeToMain():MaybeTransformer<T,T>{
        return MaybeTransformer { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }

    class RetryWithDelay(private val maxRetries:Int,private val retryDelay: Int):Function<Flowable<out Throwable>, Publisher<*>>{
        private var retryCount = 0

        init {
            retryCount = 0
        }

        override fun apply(t: Flowable<out Throwable>): Publisher<*>? {
            return t.flatMap { throwable ->
                if (++retryCount <= maxRetries) {
                    Flowable.timer(retryDelay.toLong(), TimeUnit.MILLISECONDS)

                } else {
                    // Max retries hit. Just pass the error along.
                    Flowable.error<Any>(throwable)
                }
            }
        }


    }
}