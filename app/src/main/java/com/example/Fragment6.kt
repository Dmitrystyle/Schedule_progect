package com.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.UserAdapter
import com.example.myapplication4.UserModel
import com.example.schedule.R
import com.example.schedule.databinding.Fragment6Binding
import java.util.ArrayList


class Fragment6 : Fragment() {

    lateinit var binding: Fragment6Binding
    lateinit var adapter: UserAdapter
    lateinit var recyclerView: RecyclerView
    //private var index = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_6, container, false)

        binding= Fragment6Binding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        recyclerView= binding.recyclerViewUser
        adapter=UserAdapter(this)  //присваиваем к новому
        recyclerView.adapter=adapter
        adapter.setLisrt(myUsermetod())
    }

    private fun myUsermetod(): ArrayList<UserModel> {
        val userList= ArrayList<UserModel>()

        val user= UserModel("Petrov", "Vasa")
        userList.add(user)

        val user2= UserModel("Ivanov", "Dmitry")
        userList.add(user2)

        val user3= UserModel("Vladimirov", "Sergey")
        userList.add(user3)

        val user4= UserModel("Andreev", "Ismail")
        userList.add(user4)



        return userList

    }


    companion object {

        @JvmStatic
        fun newInstance() = Fragment6()


    }


}