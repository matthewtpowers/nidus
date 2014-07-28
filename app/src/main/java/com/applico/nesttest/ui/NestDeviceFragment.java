package com.applico.nesttest.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewAnimationUtils;
import android.widget.TextView;
import android.animation.ValueAnimator;

import com.applico.nesttest.DeviceDetailsActivity;
import com.applico.nesttest.R;
import com.applico.nesttest.views.StatusCircleView;

import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NestDeviceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NestDeviceFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class NestDeviceFragment extends Fragment implements View.OnClickListener {
    private static String LOG_TAG = NestDeviceFragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Views in the layout
    private TextView mSeeMoreDetailsTv;
    private TextView mDeviceTitle;
    private StatusCircleView mCircleView;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeviceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NestDeviceFragment newInstance(String param1, String param2) {
        NestDeviceFragment fragment = new NestDeviceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public NestDeviceFragment() {
        // Required empty public constructor
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
        Log.e(LOG_TAG,"Inflating View");
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.nest_devices_fragment, container, false);
        mSeeMoreDetailsTv = (TextView)rootView.findViewById(R.id.see_more_details);
        mSeeMoreDetailsTv.setOnClickListener(this);
        mDeviceTitle = (TextView)rootView.findViewById(R.id.thermo_title);
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        Log.e(LOG_TAG,"Clicked");
        switch(view.getId())
        {
            case R.id.see_more_details:
                Intent intent = new Intent(getActivity(),DeviceDetailsActivity.class);
                mListener.onFragmentInteraction(intent, mDeviceTitle);
                break;

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Intent intent, View view);
    }


}
