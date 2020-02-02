package org.tyaa.intentsfragmentsdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentMainContainer);
        if(fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    // .replace(..., ...)
                    .add(R.id.fragmentMainContainer, fragment)
                    .commit();
        }
    }
}
