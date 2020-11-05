package com.pws.dicodingsubmission

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

/**
 * Created by PwS
 */

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UsersAdapter
    private lateinit var avatar: TypedArray
    private lateinit var username: Array<String>
    private lateinit var name: Array<String>
    private lateinit var company: Array<String>
    private lateinit var location: Array<String>
    private lateinit var repository: Array<String>
    private lateinit var followers: Array<String>
    private lateinit var following: Array<String>

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lvListUsers)
        adapter = UsersAdapter(this)
        listView.adapter = adapter
        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            /* val dataUsers = User(
                 users[position].avatar,
                 users[position].username,
                 users[position].name,
                 users[position].company,
                 users[position].location,
                 users[position].repository,
                 users[position].followers,
                 users[position].following
             )*/
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
            val moveIntentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            /* moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, dataUsers)*/
            //Change For Remove boilerplate code
            moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, users[position])
            startActivity(moveIntentToDetail)

        }

    }

    private fun prepare() {
        avatar = resources.obtainTypedArray(R.array.avatar)
        username = resources.getStringArray(R.array.username)
        name = resources.getStringArray(R.array.name)
        company = resources.getStringArray(R.array.company)
        location = resources.getStringArray(R.array.location)
        repository = resources.getStringArray(R.array.repository)
        followers = resources.getStringArray(R.array.followers)
        following = resources.getStringArray(R.array.following)

    }

    private fun addItem() {
        for (position in username.indices) {
            val user = User(
                avatar.getResourceId(position, -1),
                username[position],
                name[position],
                company[position],
                location[position],
                repository[position],
                followers[position],
                following[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}