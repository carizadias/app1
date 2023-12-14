package com.example.app1;

import androidx.recyclerview.widget.RecyclerView;

public class EmailAdapter {public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private List<EmailData> emailList;

    // Constructor to initialize with a list of EmailData objects
    public EmailAdapter(List<EmailData> emailList) {
        this.emailList = emailList;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        EmailData currentEmail = emailList.get(position);

        holder.textEmail.setText("Email: " + currentEmail.getEmail());
        holder.textPassword.setText("Password: " + currentEmail.getPassword());
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    public static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView textEmail;
        TextView textPassword;

        public EmailViewHolder(View itemView) {
            super(itemView);
            textEmail = itemView.findViewById(R.id.text_email);
            textPassword = itemView.findViewById(R.id.text_password);
        }
    }
}

}
