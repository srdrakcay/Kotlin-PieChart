package com.serdar.kotlin_piechart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.serdar.kotlin_piechart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val pieList = ArrayList<PieEntry>()
        pieList.add(PieEntry(150f, "first"))
        pieList.add(PieEntry(200f, "second"))
        pieList.add(PieEntry(300f, "third"))


        val colorSet = ArrayList<Int>()
        colorSet.add(Color.RED)  //red
        colorSet.add(Color.BLUE)  // blue
        colorSet.add(Color.GREEN)  // green

        val pieDataSet = PieDataSet(pieList,"")
        pieDataSet.colors = colorSet


        pieDataSet.sliceSpace = 0f


        val pieData = PieData(pieDataSet)
        binding.pieChart.data = pieData
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.description.isEnabled = false
        binding.pieChart.legend.isEnabled=true
        binding.pieChart.setCenterTextColor(Color.BLACK)
        binding.pieChart.centerTextRadiusPercent=0f
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)
    }
}