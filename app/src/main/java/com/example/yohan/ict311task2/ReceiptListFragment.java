package com.example.yohan.ict311task2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReceiptListFragment extends Fragment {

    private RecyclerView mReceiptRecyclerView;
    private ReceiptAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);
        mReceiptRecyclerView = (RecyclerView) view.findViewById(R.id.receipt_recycler_view);
        mReceiptRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ReceiptItems receiptItems = ReceiptItems.get(getActivity());
        List<Receipt> receipts = receiptItems.getReceipts();
        mAdapter = new ReceiptAdapter(receipts);
        mReceiptRecyclerView.setAdapter(mAdapter);
    }

    private class ReceiptHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;

        public ReceiptHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    private class ReceiptAdapter extends RecyclerView.Adapter<ReceiptHolder> {
        private List<Receipt> mReceipt;

        public ReceiptAdapter(List<Receipt> Receipts) {
            mReceipt = Receipts;
        }



        @Override
        public ReceiptHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ReceiptHolder(view);
        }

        @Override
        public void onBindViewHolder(ReceiptHolder holder, int position) {
            Receipt receipt = mReceipt.get(position);
            holder.mTitleTextView.setText(receipt.getTitle());
        }

        @Override
        public int getItemCount() {
            return mReceipt.size();
        }
    }
 }
