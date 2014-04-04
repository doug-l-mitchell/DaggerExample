package ex.dagger;

import dagger.Module;
import dagger.Provides;
import ex.dagger.app.MainActivity;
import ex.dagger.app.MultipleDependencyActivity;
import ex.dagger.service.StringGeneratorService;
import ex.dagger.service.TimeService;
import ex.dagger.service.impl.StringGeneratorServiceImpl;
import ex.dagger.service.impl.TimeServiceImpl;

/**
 * Created by dougmitchell on 4/3/14.
 */

@Module(
        injects = {
                MainActivity.class,
                MultipleDependencyActivity.class
        }
)
public class AppModule {
    @Provides TimeService provideTimeService() { return new TimeServiceImpl(); }
    @Provides StringGeneratorService provideStringGeneratorService(StringGeneratorServiceImpl stringGeneratorService) { return stringGeneratorService; }
}
