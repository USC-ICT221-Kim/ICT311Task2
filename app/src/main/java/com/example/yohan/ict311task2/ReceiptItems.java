package com.example.yohan.ict311task2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReceiptItems {

    private static ReceiptItems sReceiptItems;
    private List<Receipt> mReceipt;


    public static ReceiptItems get(Context context) {
        if (sReceiptItems == null) {
            sReceiptItems = new ReceiptItems(context);
        }
        return sReceiptItems;
    }

    private ReceiptItems(Context context) {
        mReceipt = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Receipt crime = new Receipt();
            crime.setTitle("Receipt #" + i);
            crime.setSolved(i % 2 == 0);
            mReceipt.add(crime);
        }
    }

    public List<Receipt> getCrimes() {
        return mReceipt;
    }

    public Receipt getCrime(UUID id) {
        for (Receipt crime : mReceipt) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
