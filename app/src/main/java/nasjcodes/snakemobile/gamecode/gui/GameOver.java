package nasjcodes.snakemobile.gamecode.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nasjcodes.snakemobile.R;


public class GameOver extends Fragment implements View.OnClickListener {

    public GameOver() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_over, container, false);

        //Back Button
        Button startButton = view.findViewById(R.id.back);
        startButton.setOnClickListener(this);

        //Restart Button
        Button settingsButton = view.findViewById(R.id.restart);
        settingsButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnButtonClick) {
//            mListener = (OnButtonClick) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    @Override
    public void onClick(View v) {

        if(getActivity() != null) {
            getActivity().finish();

            switch(v.getId()) {
                case R.id.back:
                    break;
                case R.id.restart:
                    startActivity(new Intent(getActivity().getApplicationContext(), Game.class));
                    break;
            }
        }

    }

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnButtonClick {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }


}
