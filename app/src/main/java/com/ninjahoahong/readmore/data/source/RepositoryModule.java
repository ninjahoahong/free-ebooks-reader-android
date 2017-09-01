package com.ninjahoahong.readmore.data.source;


import com.ninjahoahong.readmore.data.source.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    DataSource providePostsRemoteDataSource() {
        return new RemoteDataSource();
    }

}
