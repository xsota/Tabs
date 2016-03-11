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

  Fragment fragment;
boolean hoge = true;
  public EmptyFragment(){

  }

  public EmptyFragment(Fragment _fragment){
    fragment = _fragment;
  }

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

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    if(fragment != null && 1 > getChildFragmentManager().getBackStackEntryCount()){
     getChildFragmentManager()
        .beginTransaction()
        .add(R.id.container, fragment)
        .addToBackStack(null)
        //  .commit()
        .commitAllowingStateLoss()
      ;
      hoge = false;
    }

  }

  public void back(){
    getChildFragmentManager().popBackStack();
  }

  public void unko (){
    /// R.id.containerにfragmentあたっちする
   // view.findViewById(R.id.container);
    //getFragmentManager()

    getChildFragmentManager()
      .beginTransaction()
        .add(R.id.container, new UnkoFragment())
      .addToBackStack(null)
      //  .commit()
      .commitAllowingStateLoss()
      ;
  }
}
