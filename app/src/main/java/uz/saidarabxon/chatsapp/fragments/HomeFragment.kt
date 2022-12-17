package uz.saidarabxon.chatsapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import uz.saidarabxon.chatsapp.adapters.RvAdapter
import uz.saidarabxon.chatsapp.databinding.FragmentHomeBinding
import uz.saidarabxon.chatsapp.models.User


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var database: FirebaseDatabase
    private  val TAG = "HomeFragment"
    private lateinit var userReferance: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        database = FirebaseDatabase.getInstance()
        userReferance = database.getReference("users")

        rvAdapter = RvAdapter()
        binding.rv.adapter = rvAdapter


        loadData()

        return binding.root
    }

    private fun loadData() {
        userReferance.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                val children  = snapshot.children
                 for (child in children) {
                    val value = child.getValue(User::class.java)
                    if (value != null) {
                        rvAdapter.list.add(value)
                    }
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            }
        })
    }


}