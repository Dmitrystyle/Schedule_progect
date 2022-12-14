package com.example.myapplication4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.Fragment6
import com.example.schedule.R
import kotlinx.android.synthetic.main.card_design.view.*
import java.util.Collections.emptyList

class UserAdapter(private val context: Fragment6): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class  UserViewHolder (view: View):RecyclerView.ViewHolder(view)
//______создаем пустой лист по типу usermodel который будем наполнять_______
    private var userList = emptyList<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       //Откуда берем
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //привязка к сожержимому полей и нажатия по панели
        holder.itemView.textLesson.text = userList[position].lastname
        holder.itemView.text_date_and_time.text = userList[position].firstName
       // holder.itemView.setOnClickListener{ Toast.makeText(context, "${userList[position].lastname}", Toast.LENGTH_SHORT).show()}

    }

    override fun getItemCount(): Int {
        //количество возвращаемого
            return  userList.size
    }
//_________сообщаем об изменениях в адаптере_______
    fun setLisrt(list: List<UserModel>){
        userList=list
        notifyDataSetChanged()
    }


}