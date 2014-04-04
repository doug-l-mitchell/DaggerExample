package ex.dagger;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by dougmitchell on 4/3/14.
 */
public class MyApp extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new AppModule());
    }

    public ObjectGraph getObjectGraph() { return objectGraph; }
}
