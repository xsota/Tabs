package com.xsota.test.tabs.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sota on 16/03/10.
 */
public class EmptyFragment extends Fragment {
public  View view;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.empty_fragment, container, false);
    return view;
  }

  public void unko (){
    /// R.id.containerにfragmentあたっちする
   // view.findViewById(R.id.container);
    getFragmentManager().beginTransaction()
        .add(R.id.container, new UnkoFragment())
        .commit();
  }
}
