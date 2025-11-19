package com.example.course_work;

import static com.example.course_work.News_data.getNewsData;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        timetableFragment timetableFragment = new timetableFragment();
        List<timetableEntry> timetableEntries = timetableFragment.getTimetableEntriesForCurrentDate();

        // Populate the card view with timetable entries
        populateTimetableCard(rootView, timetableEntries);

        populateNewsCard(rootView);
        populateEventsCard(rootView);

        return rootView;
    }
    // Method to populate the card view with timetable entries
    private void populateTimetableCard(View rootView, List<timetableEntry> timetableEntries) {
        // Find the card view in the layout
        CardView timetableCard = rootView.findViewById(R.id.timetableCard);
        if (!timetableEntries.isEmpty()) {
            StringBuilder timetableText = new StringBuilder();
            for (timetableEntry entry : timetableEntries) {
                timetableText.append(entry.getTime()).append(" - ").append(entry.getModuleName()).append("\n");
            }
            // Set the timetable text to a TextView inside the card view
            TextView timetableTextView = timetableCard.findViewById(R.id.TimetableTextview);
            timetableTextView.setText(timetableText.toString());
        } else {
            // If no timetable entries found, you can display a message or hide the card view
            // If no timetable entries found, display a message in the TextView
            TextView timetableTextView = timetableCard.findViewById(R.id.TimetableTextview);
            timetableTextView.setText(R.string.no_timetable_data_available_for_today);
        }
    }
    private void populateNewsCard(View rootView) {
        // Find the CardView for news
        CardView newsCard = rootView.findViewById(R.id.newsCard);

        // Iterate through each news item and add it to the news card
        for (News news : getNewsData()) {
            // Inflate the news item layout for each news item
            View newsItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, null);

            // Customize the inflated news item view
            customizeNewsItem(newsItemView, news);

            // Add the customized news item view to the news card
            newsCard.addView(newsItemView);
        }
    }
    private void customizeNewsItem(View newsItemView, News news) {
        // Find views in the news item layout
        ImageView newsImageView = newsItemView.findViewById(R.id.newsImage);
        TextView newsTitleTextView = newsItemView.findViewById(R.id.newsTitle);
        TextView newsDescriptionTextView = newsItemView.findViewById(R.id.newsDescription);

        // Set data to views
        newsImageView.setImageResource(news.getImageResource());
        newsTitleTextView.setText(news.getTitle());
        newsDescriptionTextView.setText(news.getDescription());
    }
    private void populateEventsCard(View rootView) {
        // Find the CardView for events
        CardView eventsCard = rootView.findViewById(R.id.eventsCard);

        // Get the list of events data (replace this with your actual data retrieval mechanism)
        List<uni_events> eventsList = getEventsData();

        // Iterate through each event and add it to the events card
        for (uni_events event: eventsList) {
            // Inflate the event item layout for each event
            View eventItemView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, null);

            // Customize the inflated event item view
            customizeEventItem(eventItemView, event);

            // Add the customized event item view to the events card
            eventsCard.addView(eventItemView);
        }
    }

    private List<uni_events> getEventsData() {
        // Replace this with your actual data retrieval mechanism (e.g., fetching events from a database or API)
        List<uni_events> eventsList = new ArrayList<>();

        // Sample event data
        eventsList.add(new uni_events("Understanding the Risks: Exploring the Dangers of Vaping", "Whiteknight campus", "27.03.2024, 21:00 " ,R.drawable.vape));

        return eventsList;
    }
    private void customizeEventItem(View eventItemView, uni_events event) {
        // Find and set text for TextViews in the event item layout
        TextView eventNameTextView = eventItemView.findViewById(R.id.eventName);
        eventNameTextView.setText(event.getName());
        TextView eventLocationTextView = eventItemView.findViewById(R.id.eventLocation);
        eventLocationTextView.setText(event.getLocation());

        TextView eventDateTextView = eventItemView.findViewById(R.id.eventDate);
        eventDateTextView.setText(event.getDate());
    }

}