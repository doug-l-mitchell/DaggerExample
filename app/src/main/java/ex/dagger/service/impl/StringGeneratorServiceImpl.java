package ex.dagger.service.impl;

import java.util.Random;

import javax.inject.Inject;

import ex.dagger.service.StringGeneratorService;
import ex.dagger.service.TimeService;

/**
 * Created by dougmitchell on 4/3/14.
 */
public class StringGeneratorServiceImpl implements StringGeneratorService {

    private TimeService timeService;
    private Random random;

    @Inject
    public StringGeneratorServiceImpl(TimeService timeService) {
        this.timeService = timeService;
        this.random = new Random(timeService.getNow().toDate().getTime());
    }

    @Override
    public String generateString() {
        char buf[] = new char[256];
        for(int idx = 0; idx < buf.length; idx++) {
            buf[idx] = (char)(random.nextInt(126)+1);
        }
        return String.format("String generated at %s\n%s", timeService.getNow().toString(), new String(buf));
    }
}
