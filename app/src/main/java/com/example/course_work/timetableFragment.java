package com.example.course_work;

import static com.example.course_work.R.id.linearLayoutTimetableItems;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link timetableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class timetableFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    Calendar calendar;
    CalendarView calendarView;


    public timetableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment timetableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static timetableFragment newInstance(String param1, String param2) {
        timetableFragment fragment = new timetableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_timetable, container, false);
        calendarView = rootView.findViewById(R.id.calendarView);

        calendar = Calendar.getInstance();
        //setDate(22,3 ,  2024);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // Toast.makeText(requireContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                // Update the selected date
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                // Get the selected date
                showTimetablePopup();
            }
        });
        // You can customize the calendarView here if needed
        return rootView;
    }
    public List<timetableEntry> getTimetableEntriesForCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return TimetableDataSource.getTimetableEntries(dayOfWeek);
    }

    // Create a method to show the popup
    private void showTimetablePopup() {
        // Inflate the layout for the popup
        View popupView = getLayoutInflater().inflate(R.layout.pop_up_calender, null);
        // Initialize views in the popup layout
        TextView textViewTitle = popupView.findViewById(R.id.textViewTimetableDetails);
        LinearLayout linearLayoutTimetableItems = popupView.findViewById(R.id.linearLayoutTimetableItems);
        TextView textViewSelectedDate = popupView.findViewById(R.id.textViewSelectedDate);
        //ListView listView = popupView.findViewById(R.id.listView);

        // Get the selected date from the calendar
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault());
        String selectedDate = dateFormat.format(calendar.getTime());
        textViewSelectedDate.setText(selectedDate);

        // Get the day of the week from the selected date
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Retrieve timetable entries for the selected day
        List<timetableEntry> timetableEntries = TimetableDataSource.getTimetableEntries(dayOfWeek);

        // Populate the timetable items layout with timetable entries
        for (timetableEntry entry : timetableEntries) {
            TextView textViewEntry = new TextView(requireContext());
            textViewEntry.setText(entry.getTime() + " -- " + entry.getModuleName() + " -- " + entry.getLocation() + "\n");
            linearLayoutTimetableItems.addView(textViewEntry);
        }
        // Create a BottomSheetDialog to show the popup
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(popupView);

        // Optionally set behavior (e.g., expand to full screen)
        bottomSheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);

        // Show the dialog
        bottomSheetDialog.show();
    }


    /* public void setDate(int day, int month, int year){
         calendar.set(Calendar.YEAR, year);
         calendar.set(Calendar.MONTH, month );
         calendar.set(Calendar.DATE, day);
         long milli = calendar.getTimeInMillis();
         calendarView.setDate(milli);
     }
 */


}
