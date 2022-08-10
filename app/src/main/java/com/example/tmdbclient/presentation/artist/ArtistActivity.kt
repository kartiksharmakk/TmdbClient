package com.example.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.tmdbclient.presentation.artist.ArtistAdapter
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityArtistBinding
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject
@AndroidEntryPoint
class ArtistActivity : AppCompatActivity() {
    @set:Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    @set:Inject
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)


        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)
        initRecyclerView()
    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater: MenuInflater = menuInflater
            menuInflater.inflate(R.menu.update, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_update -> {
                    updateArtists()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }

        private fun initRecyclerView() {
            binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
            adapter = ArtistAdapter()
            binding.artistRecyclerView.adapter = adapter
            displayPopularArtists()
        }

        private fun displayPopularArtists() {
            binding.artistProgressBar.visibility = View.VISIBLE
            val responseLiveData = artistViewModel.getArtists()
            responseLiveData.observe(this, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.artistProgressBar.visibility = View.GONE
                } else {
                    binding.artistProgressBar.visibility = View.GONE
                    Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }

        private fun updateArtists() {
            binding.artistProgressBar.visibility = View.VISIBLE
            val reponse = artistViewModel.updateArtists()
            reponse.observe(this, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.artistProgressBar.visibility = View.GONE
                } else {
                    binding.artistProgressBar.visibility = View.GONE
                }
            })
        }

    }
