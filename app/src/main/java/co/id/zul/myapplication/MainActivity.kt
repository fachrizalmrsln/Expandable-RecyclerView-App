package co.id.zul.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mikepenz.fastadapter.expandable.getExpandableExtension

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private var listData: ArrayList<DataModel> = arrayListOf()

    private var genericList: ArrayList<GenericItem> = arrayListOf()
    private var listForChild: ArrayList<GenericItem> = arrayListOf()

    private val fastItemAdapter: GenericFastItemAdapter = FastItemAdapter()
    private lateinit var parentAdapter: ParentAdapter
    private lateinit var childAdapter: ChildAdapter
    private lateinit var grandChildAdapter: GrandChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)

        setupData()

        fastItemAdapter.getExpandableExtension().isOnlyOneExpandedItem = true

        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = fastItemAdapter
        }
    }

    private fun setupData() {
        listData.add(
            0,
            DataModel(
                "01-03-2020",
                "Title 1",
                "Subtitle 1",
                "Description 1"
            )
        )
        listData.add(
            1,
            DataModel(
                "01-03-2020",
                "Title 2",
                "Subtitle 2",
                "Description 2"
            )
        )
        listData.add(
            2,
            DataModel(
                "01-03-2020",
                "Title 3",
                "Subtitle 3",
                "Description 3"
            )
        )
        listData.add(
            3,
            DataModel(
                "01-03-2020",
                "Title 4",
                "Subtitle 4",
                "Description 4"
            )
        )
        listData.add(
            4,
            DataModel(
                "01-03-2020",
                "Title 5",
                "Subtitle 5",
                "Description 5"
            )
        )
        listData.add(
            5,
            DataModel(
                "02-03-2020",
                "Title 6",
                "Subtitle 6",
                "Description 6"
            )
        )
        listData.add(
            6,
            DataModel(
                "02-03-2020",
                "Title 7",
                "Subtitle 7",
                "Description 7"
            )
        )
        listData.add(
            7,
            DataModel(
                "02-03-2020",
                "Title 8",
                "Subtitle 8",
                "Description 8"
            )
        )
        listData.add(
            8,
            DataModel(
                "02-03-2020",
                "Title 9",
                "Subtitle 9",
                "Description 9"
            )
        )
        listData.add(
            9,
            DataModel(
                "03-03-2020",
                "Title 10",
                "Subtitle 10",
                "Description 10"
            )
        )

        listData.add(
            10,
            DataModel(
                "01-03-2020",
                "Title 11",
                "Subtitle 11",
                "Description 11"
            )
        )
        listData.add(
            11,
            DataModel(
                "01-03-2020",
                "Title 12",
                "Subtitle 12",
                "Description 12"
            )
        )
        listData.add(
            12,
            DataModel(
                "01-03-2020",
                "Title 13",
                "Subtitle 13",
                "Description 13"
            )
        )
        listData.add(
            13,
            DataModel(
                "01-03-2020",
                "Title 14",
                "Subtitle 14",
                "Description 14"
            )
        )
        listData.add(
            14,
            DataModel(
                "01-03-2020",
                "Title 15",
                "Subtitle 15",
                "Description 15"
            )
        )
        listData.add(
            15,
            DataModel(
                "02-03-2020",
                "Title 16",
                "Subtitle 16",
                "Description 16"
            )
        )
        listData.add(
            16,
            DataModel(
                "02-03-2020",
                "Title 7",
                "Subtitle 17",
                "Description 17"
            )
        )
        listData.add(
            17,
            DataModel(
                "02-03-2020",
                "Title 8",
                "Subtitle 18",
                "Description 18"
            )
        )
        listData.add(
            18,
            DataModel(
                "02-03-2020",
                "Title 19",
                "Subtitle 19",
                "Description 19"
            )
        )
        listData.add(
            19,
            DataModel(
                "03-03-2020",
                "Title 20",
                "Subtitle 20",
                "Description 20"
            )
        )

        initializeData(listData)
    }

    private fun initializeData(data: ArrayList<DataModel>) {
        val sortedList = data.sortedByDescending { it.date }
        val groupByDate = sortedList.groupBy { dataGroup ->
            dataGroup.date
        }

        groupByDate.keys.forEach { key ->
            parentAdapter = ParentAdapter(key)
            groupByDate[key]?.forEach {
                childAdapter = ChildAdapter(it)
                grandChildAdapter = GrandChildAdapter(it)
                childAdapter.subItems.add(grandChildAdapter)
                listForChild.add(childAdapter)
            }
            genericList.add(parentAdapter)
            genericList.addAll(listForChild)
            listForChild.clear()
        }
        fastItemAdapter.add(genericList)
    }

}
