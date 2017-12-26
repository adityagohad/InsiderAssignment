package in.adzlab.insiderassignment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.adzlab.insiderassignment.R;
import in.adzlab.insiderassignment.model.Filter;
import in.adzlab.insiderassignment.model.InsiderEvent;
import in.adzlab.insiderassignment.ui.adapter.EventsAdapter;

/**
 * Created by adityagohad on 26/12/17.
 */

public class InsiderEventListFragment extends Fragment {
    List<InsiderEvent> insiderEvents = new ArrayList<>();
    RecyclerView eventsRv;
    LinearLayoutManager linearLayoutManager;
    EventsAdapter adapter;
    List<Filter> genres = new ArrayList<>();

    public static InsiderEventListFragment newInstance(List<InsiderEvent> insiderEvents){
        InsiderEventListFragment insiderEventListFragment = new InsiderEventListFragment();
        insiderEventListFragment.insiderEvents.addAll(insiderEvents);
        insiderEventListFragment.genres.removeAll(insiderEventListFragment.genres);
        List<String> unique = new ArrayList<>();
        for(InsiderEvent insiderEvent : insiderEvents){
            if(!unique.contains(insiderEvent.getCategory_id().getName())){
                unique.add(insiderEvent.getCategory_id().getName());
            }
        }
        for(String uni : unique){
            insiderEventListFragment.genres.add(new Filter(uni, uni, false));
        }

        return insiderEventListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        eventsRv = (RecyclerView) view.findViewById(R.id.ie_rv);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        eventsRv.setLayoutManager(linearLayoutManager);
        adapter = new EventsAdapter(getContext(), insiderEvents);
        eventsRv.setAdapter(adapter);
        return view;
    }

    public List<Filter> getGenres() {
        return genres;
    }

    public void applyFilters(List<String> filters){
        List<InsiderEvent> events = new ArrayList<>();
        for(String filter : filters){
            for(InsiderEvent insiderEvent : insiderEvents){
                if(filter.equals(insiderEvent.getCategory_id().getName())){
                    events.add(insiderEvent);
                }
                if(insiderEvent.getApplicable_filters().contains(filter)){
                    events.add(insiderEvent);
                }
            }
        }
        adapter.swapData(events);
    }
}
