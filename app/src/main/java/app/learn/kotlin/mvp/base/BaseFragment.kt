package app.learn.kotlin.mvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.design.snackbar

abstract class BaseFragment<out T : BasePresenter> : Fragment(), BaseView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.getPresenter()?.run {
            this.onAttach()
        }

        return onInitView(inflater, container, savedInstanceState)
    }

    abstract fun getPresenter(): T?

    protected abstract fun onInitView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View

    override fun showMessage(message: String) {
        this.view?.rootView?.let {
            snackbar(it, message)
        }
    }
}