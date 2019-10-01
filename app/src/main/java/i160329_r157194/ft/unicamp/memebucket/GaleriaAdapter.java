package i160329_r157194.ft.unicamp.memebucket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class GaleriaAdapter extends RecyclerView.Adapter {
    private ArrayList<Memes> listaMemes;

    public GaleriaAdapter(ArrayList<Memes> listaMemes){
        this.listaMemes = listaMemes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        final MyFirstViewHolder holder = new MyFirstViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Memes meme = listaMemes.get(position);
        ((MyFirstViewHolder)holder).onBind(listaMemes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listaMemes.size();
    }

    private class MyFirstViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView descricao;
        private TextView memeNome;
        private int position;

        public MyFirstViewHolder(final View itemView) {
            super(itemView);
            memeNome = itemView.findViewById(R.id.meme_nome_fragment);
            imageView = itemView.findViewById(R.id.meme_image_fragment);
            descricao = itemView.findViewById(R.id.meme_description_fragment);
            position = getAdapterPosition();
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void onBind(Memes memes, final int position) {
            memeNome.setText(memes.getNome());
            imageView.setImageURI(memes.getUri());
            descricao.setText(memes.getDescricao());
        }
    }
}