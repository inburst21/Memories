package iskills.com.memories.di.providers.date;

import java.util.Calendar;

/**
 * lennyhicks
 * 4/3/18
 */
public interface PresenterDate {

    void openDatePicker(Listener listener);
    String formatDate(Calendar dateFromDatePicker);

    String getCurrentDate();

    Calendar getCurrentCalender();

    interface Listener{
        void onDatePickerSet(Calendar dateFromDatePicker);
    }
}
