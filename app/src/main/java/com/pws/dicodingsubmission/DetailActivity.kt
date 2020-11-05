package com.pws.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by PwS
 */

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    //ForButtonBack
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val users = intent.getParcelableExtra(DETAIL_USER) as User

        users_photo.setImageResource(users.avatar)
        name_user.text = users.name
        username_github.text = "@${users.name}"
        company.text = getString(R.string.user_company, users.company)
        location.text = getString(R.string.user_location, users.location)
        repository.text = getString(R.string.user_repository, users.repository)
        followers.text = getString(R.string.user_followers, users.followers)
        following.text = getString(R.string.user_following, users.following)
    }
}