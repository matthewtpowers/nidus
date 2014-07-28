package com.applico.nesttest.ui;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.applico.nesttest.R;
import com.applico.nesttest.utils.GenericConstants;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NestAuthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NestAuthFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class NestAuthFragment extends Fragment implements View.OnClickListener {

    private static String LOG_TAG = NestAuthFragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mRootView;
    private Button mSubmitAuthCodeBtn;

    private EditText mSubmitAuthCodeEText;
    private WebView mAuthWebView;

    //TODO: Change on every subsequent auth call
    //Need to have a state string, it should be changed on every request
    private static String mState = "&state=0139";
    private static String mAccessTokenURI = "https://api.home.nest.com/oauth2/access_token?code=AUTHORIZATION_CODE&client_id=2ed12941-0134-4e77-85f9-793896e44e24&client_secret=V08y0eCN7KX5HwNEPfKrQysy7&grant_type=authorization_code";

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String auth_code);
    }


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NestAuthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NestAuthFragment newInstance(String param1, String param2) {
        NestAuthFragment fragment = new NestAuthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public NestAuthFragment() {
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
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.nest_webview_auth_fragment, container, false);
        mSubmitAuthCodeBtn = (Button)mRootView.findViewById(R.id.submit_auth_code);
        mSubmitAuthCodeBtn.setOnClickListener(this);
        mSubmitAuthCodeEText = (EditText)mRootView.findViewById(R.id.editText_auth_code);
        mAuthWebView = (WebView)mRootView.findViewById(R.id.webView);
        //TODO: Move off the main thread
        mAuthWebView.loadUrl(GenericConstants.NEST_AUTH_URI + GenericConstants.NEST_CLIENT_ID + mState);
        mAuthWebView.getSettings().setJavaScriptEnabled(true);


        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String str) {
        if (mListener != null) {
            mListener.onFragmentInteraction(str);
        }
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
        switch(view.getId())
        {
            case R.id.submit_auth_code:
                String str = mSubmitAuthCodeEText.getText().toString();
                if(str.isEmpty())
                {
                    Toast.makeText(getActivity(),"Auth Code Cannot Be Empty",Toast.LENGTH_LONG).show();
                }
                else
                {
                    mListener.onFragmentInteraction(str);
                }
                break;
        }
    }



}
