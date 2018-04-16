package iskills.com.memoriesrefactor.di.activity.utils.date;

import android.app.Application;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;


/**
 * lennyhicks
 * 4/5/18
 */
class UtilsDate implements PresenterDate {

    private final Application application;
    private Calendar calendar = Calendar.getInstance();

    @Inject
    UtilsDate(Application application){
        this.application = application;

    }

    @Override
    public void openDatePicker(PresenterDate.Listener listener) {
        DatePickerDialog mDatePicker = new DatePickerDialog(application,
                (datePicker, year, month, day) -> listener.onDatePickerSet(getDateFromDatePicker(datePicker)), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        mDatePicker.show();    }

    @Override
    public String formatDate(Calendar calendar) {
        return SimpleDateFormat.getDateInstance().format(calendar.getTime());
    }

    @Override
    public String getCurrentDate() {
        return SimpleDateFormat.getDateInstance().format(calendar.getTime());
    }

    @Override
    public Calendar getCurrentCalender() {
        return calendar;
    }

    private Calendar getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }
}
