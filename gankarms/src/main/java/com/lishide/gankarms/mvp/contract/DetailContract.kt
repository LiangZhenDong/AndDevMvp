package com.lishide.gankarms.mvp.contract

import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import com.lishide.gankarms.mvp.model.entity.GankEntity

interface DetailContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView {
        fun onLikeChange(isLike: Boolean)
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel {
        fun queryById(id: String): List<GankEntity>
        fun removeById(id: String)
        fun addToLike(entity: GankEntity)
    }
}
