package com.todobom.queenscanner.Data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.squareup.picasso.Picasso;
import com.todobom.queenscanner.FutureSavedPDF;
import com.todobom.queenscanner.R;

import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder> {

    private Context context;
    //    private String [] blogList;
    private List<String> blogList;
    private List<String> pdfNameList;
    private OnPDFclickListener monPDFclickListener;

    public PdfAdapter() {
    }

    public PdfAdapter(Context context, List<String> blogList, List<String> blogList2, OnPDFclickListener onPDFclickListener) {
        this.context = context;
        this.blogList = blogList;
        this.pdfNameList = blogList2;
        this.monPDFclickListener = onPDFclickListener;

    }

    @NonNull
    @Override
    public PdfAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_future_save_pdf_row,parent,false);

        return new PdfAdapter.ViewHolder(view, context , monPDFclickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfAdapter.ViewHolder holder, int position) {

        holder.name.setText(pdfNameList.get(position));

        //        holder.datee.setText(blogList.get());

    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView datee;

        OnPDFclickListener onPDFclickListener;

        public ViewHolder(@NonNull View view, Context ctx, OnPDFclickListener onPDFclickListener) {
            super(view);

            this.onPDFclickListener = onPDFclickListener;
            context = ctx;
            name = view.findViewById(R.id.pdfName);
            datee = view.findViewById(R.id.pdfDate);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onPDFclickListener.onPdfclick(getAdapterPosition());
        }
    }

    public interface OnPDFclickListener{
        void onPdfclick(int position);
    }

}
