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
            Receipt receipt = new Receipt();
            receipt.setTitle("Receipt #" + i);
            receipt.setSolved(i % 2 == 0);
            mReceipt.add(receipt);
        }
    }

    public List<Receipt> getReceipts() {
        return mReceipt;
    }

    public Receipt getReceipt(UUID id) {
        for (Receipt receipts : mReceipt) {
            if (receipts.getId().equals(id)) {
                return receipts;
            }
        }
        return null;
    }
}
