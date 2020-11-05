package com.pws.dicodingsubmission

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by PwS
 */

class UsersAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getCount(): Int = users.size
    override fun getItem(position: Int): Any = users[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val users = getItem(position) as User
        viewHolder.bind(users)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtUserName: TextView = view.findViewById(R.id.tvUsername)
        private val txtName: TextView = view.findViewById(R.id.tvName)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        internal fun bind(users: User) {
            txtUserName.text = users.username
            txtName.text = users.name
            imgPhoto.setImageResource(users.avatar)
        }
    }
}