package app.learn.kotlin.di.module.builder

import app.learn.kotlin.mvp.league.MainActivity
import app.learn.kotlin.mvp.league.MainModule
import app.learn.kotlin.di.scope.ActivityScope
import app.learn.kotlin.mvp.event.detail.MatchDetailActivity
import app.learn.kotlin.mvp.event.detail.MatchDetailModule
import app.learn.kotlin.mvp.event.match.MatchFragment
import app.learn.kotlin.mvp.event.match.MatchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun provideMainActivity() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchModule::class])
    abstract fun provideMatchFragment(): MatchFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchDetailModule::class])
    abstract fun provideMatchDetailFragment(): MatchDetailActivity
}