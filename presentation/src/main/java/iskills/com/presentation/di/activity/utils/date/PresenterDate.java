package iskills.com.presentation.di.activity.utils.date;

import java.util.Calendar;

/**
 * lennyhicks
 * 4/3/18
 */
public interface PresenterDate {

    void openDatePicker(Listener listener);
    String formatDate(Calendar dateFromDatePicker);

    interface Listener{
        void onDatePickerSet(String  dateFromDatePicker);
    }
}
