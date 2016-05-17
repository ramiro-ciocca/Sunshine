package com.lulisoft.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayAdapter<String> mForecastAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] forecastArray = {
                "Hoy - Soleado - 32º/22º",
                "Mañana - Nublado - 22º/12º",
                "Miércoles - Lluvioso - 12º/2º",
                "Jueves - Nevando - 2º/-12º",
                "Viernes - Soleado - 40º/28º",
                "Sábado - Niebla - 22º/12º",
                "Domingo - Granizo - 2º/-16º"
        };
        List<String> weekForecast = new ArrayList<>(Arrays.asList(forecastArray));
        mForecastAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listViewForecast = (ListView) rootView.findViewById(R.id.listview_forecast);
        listViewForecast.setAdapter(mForecastAdapter);

        return rootView;
    }
}
