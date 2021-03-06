package com.shehuan.wanandroid.base.activity

import android.os.Bundle
import com.shehuan.wanandroid.base.BasePresenter

abstract class BaseMvpActivity<P : BasePresenter<*>> : BaseActivity() {
    lateinit var presenter: P

    abstract fun initPresenter(): P

    abstract fun loadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
        loadData()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}