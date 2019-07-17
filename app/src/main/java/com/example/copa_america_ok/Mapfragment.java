package com.example.copa_america_ok;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import static android.app.AlertDialog.*;

public class Mapfragment extends DialogFragment {
   public static final String ARGUMENTO_TITLE ="TITLE";
    public static final String ARGUMENTO_FULL_SNIPPET ="FULL_SNIPPET";
  private String title;
  private String FullSnippet;

  public static Mapfragment newInstance(String title, String fullSnippet){
      Mapfragment fragment = new Mapfragment();
      Bundle b;
      b = new Bundle();
      b.putString(ARGUMENTO_TITLE,title);
      b.putString(ARGUMENTO_FULL_SNIPPET,fullSnippet);
      fragment.setArguments(b);
      return fragment;
  }

    @Override
    public void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      Bundle args= getArguments();
      title=args.getString(ARGUMENTO_TITLE);
      FullSnippet=args.getString(ARGUMENTO_FULL_SNIPPET);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(FullSnippet)
                .create();
      return dialog;
  }


}
