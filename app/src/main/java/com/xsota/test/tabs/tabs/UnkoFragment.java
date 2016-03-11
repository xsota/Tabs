package com.xsota.test.tabs.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sota on 16/03/10.
 */
public class UnkoFragment extends Fragment {


  @OnClick(R.id.button)
  public void unkounko(){
    //getChildFragmentManager().popBackStack();
    getActivity().getFragmentManager().popBackStack();
    Log.d("unko","unko");
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    View view = inflater.inflate(R.layout.unko_fragment, container, false);
    ButterKnife.bind(this,view);

    return view;
  }
}
