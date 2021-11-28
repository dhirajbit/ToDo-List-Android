package com.nishant.dev.todolist.bottomNavigationFragments.archivedFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nishant.dev.todolist.R
import com.nishant.dev.todolist.database.ToDo
import com.nishant.dev.todolist.database.ToDoDao

class ArchivedFragment(private val dbDao: ToDoDao) : Fragment() {

    var archivedList: MutableList<ToDo>? = null
    lateinit var archivedAdapter: ArchivedTasksListAdapter

    var args = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf =  inflater.inflate(R.layout.fragment_archived, container, false)

        archivedList = dbDao.getArchivedTasks()
        Log.d("DoneTasks", archivedList.toString())

        // Send data to recyclerview adapter.
        val tasksRecyclerView = inf.findViewById<RecyclerView>(R.id.doneRecyclerView)

        archivedAdapter = ArchivedTasksListAdapter(archivedList!!, dbDao)

        tasksRecyclerView.layoutManager = LinearLayoutManager(context)
        tasksRecyclerView.adapter = archivedAdapter

        return inf
    }
}