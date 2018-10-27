package com.example.yohan.ict311task2;

import android.support.v4.app.Fragment;

public class ReceiptListActivity  extends SingleFragmentActivity  {
    @Override
    protected Fragment createFragment() {
        return new ReceiptListFragment();
    }
}
