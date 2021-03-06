/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.module;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import id.co.next_innovation.go_mik.data.db.entity.Comic;
import id.co.next_innovation.go_mik.data.network.ComicResponse;
import id.co.next_innovation.go_mik.di.PerActivity;
import id.co.next_innovation.go_mik.ui.category.CategoryMvpPresenter;
import id.co.next_innovation.go_mik.ui.category.CategoryPresenter;
import id.co.next_innovation.go_mik.ui.category.CategoryView;
import id.co.next_innovation.go_mik.ui.comic.ComicAdapter;
import id.co.next_innovation.go_mik.ui.comic.ComicMvpPresenter;
import id.co.next_innovation.go_mik.ui.comic.ComicPresenter;
import id.co.next_innovation.go_mik.ui.comic.ComicView;
import id.co.next_innovation.go_mik.ui.episode.EpisodeMvpPresenter;
import id.co.next_innovation.go_mik.ui.episode.EpisodePresenter;
import id.co.next_innovation.go_mik.ui.episode.EpisodeView;
import id.co.next_innovation.go_mik.ui.home.HomeMvpPresenter;
import id.co.next_innovation.go_mik.ui.home.HomePresenter;
import id.co.next_innovation.go_mik.ui.splash.SplashMvpPresenter;
import id.co.next_innovation.go_mik.ui.splash.SplashPresenter;
import id.co.next_innovation.go_mik.utils.rx.AppSchedulerProvider;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import id.co.next_innovation.go_mik.di.ActivityContext;
import id.co.next_innovation.go_mik.ui.home.HomeView;
import id.co.next_innovation.go_mik.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    HomeMvpPresenter<HomeView> provideHomePresenter(
            HomePresenter<HomeView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ComicMvpPresenter<ComicView> provideComicPresenter(
            ComicPresenter<ComicView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    EpisodeMvpPresenter<EpisodeView> provideEpisodePresenter(
            EpisodePresenter<EpisodeView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CategoryMvpPresenter<CategoryView> provideCategoryPresenter(
            CategoryPresenter<CategoryView> presenter) {
        return presenter;
    }

    @Provides
    ComicAdapter provideComicsAdapter() {
        return new ComicAdapter(new ArrayList<Comic>());
    }
}
