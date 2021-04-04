package com.example.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//مرحله اول بعد از ساخت فرگمنت ها
//در مرحله اول برای dependency injection این کلاس را باید بسازیم و در مانیفست تعریفش میکنیم که بگیم در سطح اپلیکیشن میخوایم از دگر هیلت استفاده کنیم
@HiltAndroidApp
class NewsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.DebugTree()
    }
}