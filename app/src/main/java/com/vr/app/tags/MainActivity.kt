package com.vr.app.tags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private lateinit var allTags:ChipGroup
    private lateinit var selectedTags:ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allTags = findViewById(R.id.allTagsGroupe)
        selectedTags = findViewById(R.id.selected_tags)

        for (i in resources.getStringArray(R.array.tagsList)){
            allTags.addView(AddChip(i))
        }
    }



    fun AddChip(textTag:String):Chip{
        val chip = Chip(this)
        val chip_selected = Chip(this,null,R.attr.CustomChipChoice)
        chip.text = textTag

        chip.setOnClickListener {
            chip_selected.text = textTag
            selectedTags.addView(chip_selected)
            allTags.removeView(chip)
        }

        chip_selected.setOnClickListener {
            allTags.addView(chip)
            selectedTags.removeView(chip_selected)
        }
//        chip.isCloseIconVisible = true
        return chip
    }
}