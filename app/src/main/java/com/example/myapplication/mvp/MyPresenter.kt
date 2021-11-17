package com.example.myapplication.mvp

class MyPresenter(iView: IShowView) {

    private var iView: IShowView? = iView
    fun showText(text: String) {

        iView?.showText(text)
    }

}