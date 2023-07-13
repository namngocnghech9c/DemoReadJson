package namtdph08817.android.demoreadjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import namtdph08817.android.demoreadjson.entity.UserModel;

public class JAdapter extends RecyclerView.Adapter<JAdapter.viewHolder> {
    private ArrayList<UserModel> arrayList;
    private Context context;

    public JAdapter(ArrayList<UserModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public JAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,viewGroup,false);
        return new JAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JAdapter.viewHolder holder, int i) {
        UserModel model = arrayList.get(i);
        if(model == null)
            return;
        holder.tv_name.setText(model.getName());
        holder.tv_craft.setText(model.getCraft());
    }

    @Override
    public int getItemCount() {
        if (arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_craft;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_craft = itemView.findViewById(R.id.tv_craft);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
