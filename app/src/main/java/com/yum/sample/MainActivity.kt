package com.yum.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.yum.sample.presenters.Presenter


class MainActivity : AppCompatActivity(), CustomActivity {

    companion object {
        private const val EXTRA_THEME = "extra_theme"
        private const val URL = "URL"
        private const val PORT = "PORT"
    }

    private val currentTheme by lazy {
        intent.getIntExtra(EXTRA_THEME, R.style.Default)
    }


    val presenter: Presenter = Presenter(this)
    var url: String = ""
    var port: Int = 0

    fun getServer(): String {
        return "$url:$port"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(currentTheme)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        load()
    }

    @SuppressLint("InflateParams")
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment)
                as NavHostFragment? ?: return
        val navController = host.navController
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val isMenu = destination.id == R.id.mainMenu
            toolbar.isGone = isMenu
        }
        appBarConfiguration.topLevelDestinations.add(R.id.mainMenu)
        //appBarConfiguration.topLevelDestinations.add(R.id.fragmentList)
        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        if (port == 0 || url == "") {
            showLoginDialog()
        }
    }

    fun showLoginDialog(){
        val li = LayoutInflater.from(this)
        val promptsView: View = li.inflate(R.layout.login_dialog, null)
        val mDialogBuilder =
            AlertDialog.Builder(this)

        mDialogBuilder.setView(promptsView)
        val userInput =
            promptsView.findViewById<View>(R.id.input_text_url) as EditText
        val portInput = promptsView.findViewById<View>(R.id.input_text_port) as EditText
        mDialogBuilder
            .setCancelable(false)
            .setPositiveButton(
                "Войти"
            ) { dialog, id ->
                url = userInput.text.toString()
                port = portInput.text.toString().toInt()
                save()
            }
            .setNegativeButton(
                "Отмена"
            ) { dialog, id ->
                dialog.cancel()
                url = "localhost"
                port = 8080
                save()
            }
        val alertDialog = mDialogBuilder.create()

        alertDialog.show()
    }

    override fun navigate(navController: NavController, id: Int) {
        presenter.onNavigate(navController, id)
    }

    override fun navigate(navController: NavController, id: Int, idArg: Int) {
        presenter.onNavigate(navController, id, idArg)
    }

    override fun bindTiles(view: MenuView) {
        presenter.onBindTiles(view)
    }

    override fun bindList(id: Int, fragment: CustomView) {
        presenter.onBindList(id, fragment)
    }

    override fun listItemPressed(id: Int, navController: NavController) {
        presenter.onListItemClick(id, navController)
    }

    override fun tilePressed(v: View?, view: MenuView) {
        presenter.onTileClick(v, view)
    }

    override fun setTitle(titleId: Int) {
        presenter.onBindTitle(titleId)
    }

    override fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun gettitle(): String {
        return supportActionBar?.title.toString()
    }

    fun save() {
        val pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString(URL, url)
        ed.putInt(PORT, port)
        ed.commit()
        Toast.makeText(this, "Подключено к серверу: \n $url : $port", Toast.LENGTH_SHORT).show()
    }

    fun load() {
        val pref = getPreferences(MODE_PRIVATE)
        url = pref.getString(URL, "") ?: ""
        port = pref.getInt(PORT, 0)
        if (port != 0)
            Toast.makeText(this, "Подключено к серверу: \n $url : $port", Toast.LENGTH_SHORT).show()
    }
}
