package com.gmail.maks347743.feature_gamelist_impl.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MostAnticipatedGamesRepositoryType

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LatestReleasesRepositoryType

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MostRatedGamesRepositoryType

