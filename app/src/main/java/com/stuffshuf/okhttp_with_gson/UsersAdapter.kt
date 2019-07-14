package com.stuffshuf.okhttp_with_gson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.users_list.view.*

class UsersAdapter(val users:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.users_list, parent, false)
        return UsersViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return users.size

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val usersdata=users[position]
        holder.bind(usersdata)

    }


    class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(users: Users)
        {
            with(itemView)
            {
               // tvlogin.text=item.items.toString()
                tvlogin.text=users.login
                 tvid.text=users.id.toString()
                Picasso.get().load(users.avatar_url).into(img)


                // tvlogin.text=item.items.toString()
                //tvNAME.text=users.id.toString()
             //   tvEMAIL.text=users.node_id
              //  tvID.text=users.id.toString()
               // tvNAME.text=users.name
               // tvUSERNAME.text=users.username
               // tvEMAIL.text=users.email
               // tvADDRESS.text=users.address.toString()
               // tvGEO.text=users.geo.toString()

            }


        }
    }


}