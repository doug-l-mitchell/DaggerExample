package ex.dagger.service;

import org.joda.time.DateTime;

/**
 * Created by dougmitchell on 4/3/14.
 */
public interface TimeService {
    DateTime getNow();
    DateTime getThisTimeTomorrow();
    DateTime getThisTimeNextWeek();
}
