package com.example.yapilacaklarlistesi;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyDoes> myDoes;

    public DoesAdapter(Context c, ArrayList<MyDoes> p) {
        context = c;
        myDoes = p;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder( LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup, false));
    }


    @Override
    public void onBindViewHolder( final MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(myDoes.get(i).getBaslik());
        myViewHolder.descdoes.setText(myDoes.get(i).getAciklama());
        myViewHolder.datedoes.setText(myDoes.get(i).getTarih());
//        myViewHolder.keydoes.setText(myDoes.get(i).getKeydoes());

        final String getTitleDoes = myDoes.get(i).getBaslik();
        final String getDescDoes = myDoes.get(i).getAciklama();
        final String getDateDoes = myDoes.get(i).getTarih();
        final String getKeyDoes = myDoes.get(i).getKeydoes();

        // final String getKeyDoes = myDoes.get(i).ge();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context,EditTaskDesk.class);
                aa.putExtra("baslik", getTitleDoes);
                aa.putExtra("aciklama", getDescDoes);
                aa.putExtra("tarih", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);

                context.startActivity(aa);
            }
        });

    }

    @Override
    public int getItemCount( ) {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titledoes, descdoes, datedoes, keydoes;
        public MyViewHolder(View itemView) {
            super( itemView );
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView ) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);

        }
    }


}
