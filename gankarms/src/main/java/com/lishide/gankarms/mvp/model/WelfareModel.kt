package com.lishide.gankarms.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.lishide.gankarms.mvp.contract.WelfareContract
import com.lishide.gankarms.mvp.model.api.service.CommonService
import com.lishide.gankarms.mvp.model.entity.GankEntity
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScope
class WelfareModel @Inject
constructor(repositoryManager: IRepositoryManager, private var mGson: Gson?, private var mApplication: Application?) : BaseModel(repositoryManager), WelfareContract.Model {
    override fun getRandomGirl(): Observable<GankEntity> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java)
                .getRandomGirl()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.mGson = null
        this.mApplication = null
    }

}