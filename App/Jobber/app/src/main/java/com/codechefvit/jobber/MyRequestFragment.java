package com.codechefvit.jobber;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyRequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyRequestFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private RequestsAdapter requestsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int[] ids;
    private int[] images;
    private String[] head;
    private String[] location;

    public MyRequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyRequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyRequestFragment newInstance(String param1, String param2) {
        MyRequestFragment fragment = new MyRequestFragment();
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
        View view= inflater.inflate(R.layout.fragment_my_request, container, false);

        ids=new int[] {4,5};
        images=new int[] {R.drawable.prof,R.drawable.prof};
        head=new String[] {"Amazon Parcel","Flipkart Parcel"};
        location=new String[] {"D-Annexe","Main Gate"};

        //container.findViewById(R.id.addbtn).setEnabled(true);

        recyclerView=view.findViewById(R.id.recyclerView1);
        recyclerView.hasFixedSize();
        layoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        requestsAdapter=new RequestsAdapter(ids,images,head,location,view.getContext());
        recyclerView.setAdapter(requestsAdapter);
        return view;
    }
}