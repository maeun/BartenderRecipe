package com.maeun.bartenderrecipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {

    val cocktail = intArrayOf(R.string.poussecafe, R.string.manhattan, R.string.drymartini, R.string.oldfashioned, R.string.brandyalexander,
            R.string.bloodymary, R.string.singaporesling, R.string.blackrussian, R.string.margarita, R.string.rustynail,
            R.string.whiskeysour, R.string.newyork, R.string.harveywallbanger, R.string.daiquiri, R.string.kissoffire,
            R.string.b52, R.string.junebug, R.string.bacardi, R.string.sloeginfizz, R.string.cubalibre,
            R.string.grasshopper, R.string.seabreeze, R.string.applemartini, R.string.negroni, R.string.longislandicedtea,
            R.string.sidecar, R.string.maitai, R.string.pinacolada, R.string.cosmopolitan, R.string.moscowmule,
            R.string.apricot, R.string.honeymoon, R.string.bluehawaiian, R.string.kir, R.string.tequilasunrise,
            R.string.healing, R.string.jindo, R.string.puppylove, R.string.geumsan, R.string.gochang)

    val poussecafe_ = arrayOf("poussecafe", "Stemed Liqueur Glass", "Float", "", "https://youtu.be/Qn2kN4j5aBw")
    val poussecafeBase = arrayOf("Grenadine Syrup", "Crème de Menthe(Green)", "Brandy")
    val poussecafeRatio = arrayOf("1/3", "1/3", "1/3")

    val manhattan_ = arrayOf("manhattan", "Cocktail Glass", "Stir", "Cherry", "https://youtu.be/3Z4UoRUKdcI")
    val manhattanBase = arrayOf("Bourbon Whiskey", "Sweet Vermouth", "Angostura Bitters")
    val manhattanRatio = arrayOf("1 1/2", "3/4", "1D")

    val drymartini_ = arrayOf("drymartini", "Cocktail Glass", "Stir", "Green Olive", "https://youtu.be/RBkvLOEPqwA")
    val drymartiniBase = arrayOf("Dry Gin", "Dry Vermouth")
    val drymartiniRatio = arrayOf("2", "1/3")

    val oldfashioned_ = arrayOf("oldfashioned", "Old-fashioned Glass", "Build", "A Slice of Orange and Cherry", "https://youtu.be/mycKEmhkj-E")
    val oldfashionedBase = arrayOf("Bourbon Whiskey", "Cubed Sugar", "Angostura Bitters", "Soda Water")
    val oldfashionedRatio = arrayOf("1 1/2", "1ea", "1D", "1/2")

    val brandyalexander_ = arrayOf("brandyalexander", "Cocktail Glass", "Shake", "Nutmeg Powder", "https://youtu.be/9gelfaXaCME")
    val brandyalexanderBase = arrayOf("Brandy", "Crème de Cacao(Brown)", "Light Milk")
    val brandyalexanderRatio = arrayOf("3/4", "3/4", "3/4")

    val poussecafe = arrayOf(poussecafe_, poussecafeBase, poussecafeRatio)
    val manhattan = arrayOf(manhattan_, manhattanBase, manhattanRatio)
    val drymartini = arrayOf(drymartini_, drymartiniBase, drymartiniRatio)
    val oldfashioned = arrayOf(oldfashioned_, oldfashionedBase, oldfashionedRatio)
    val brandyalexander = arrayOf(brandyalexander_, brandyalexanderBase, brandyalexanderRatio)

    val recipe = arrayOf(poussecafe, manhattan, drymartini, oldfashioned, brandyalexander)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        cocktailNameTv.setText(recipe[0][0][0])
//        recipe_1.setText(recipe[0][1][1])
//
//        randomBtn.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(recipe[0][0][3])
//            startActivity(intent)
    }


//        cocktailNameTv.setText(cocktail[(Math. random() * cocktail.size).toInt()])

//        randomBtn.setOnClickListener {
//            cocktailNameTv.setText(cocktail[(Math.random() * cocktail.size).toInt()])
//        }

}

