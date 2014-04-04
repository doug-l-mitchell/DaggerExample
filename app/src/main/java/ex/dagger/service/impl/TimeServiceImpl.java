package ex.dagger.service.impl;

import org.joda.time.DateTime;

import ex.dagger.service.TimeService;

/**
 * Created by dougmitchell on 4/3/14.
 */
public class TimeServiceImpl implements TimeService {
    @Override
    public DateTime getNow() {
        return DateTime.now();
    }

    @Override
    public DateTime getThisTimeTomorrow() {
        return DateTime.now().plusDays(1);
    }

    @Override
    public DateTime getThisTimeNextWeek() {
        return DateTime.now().plusWeeks(1);
    }
}
