package com.example.myapplicationimport android.content.Intentimport android.os.Bundleimport android.util.Logimport android.view.Viewimport androidx.appcompat.app.AppCompatActivityimport androidx.recyclerview.widget.LinearLayoutManagerimport androidx.recyclerview.widget.RecyclerViewimport com.example.myapplication.bottomNav.BottomNavActivityimport com.example.myapplication.test.weather.WeatherActivityimport com.example.myapplication.databinding.DataBindingActivityimport com.example.myapplication.login.LoginActivityimport com.example.myapplication.looper.LooperActivityimport com.example.myapplication.qrscan.QrScanActivityimport com.example.myapplication.tab.TabActivityimport com.example.myapplication.thread.ThreadActivityimport io.flutter.embedding.android.FlutterActivityclass MainActivity : AppCompatActivity(), ListViewItemClickListener {    private val items = listOf(        "跳转flutter module", "kotlin mvvm", "dataBinding", "顶部导航栏","底部导航栏","thread","登录","looper","zxinglite qrscan"    )    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContentView(R.layout.activity_main)        LifecycleObserver<MainActivity>().register(this)        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)        val layoutManager = LinearLayoutManager(this)        recyclerView.layoutManager = layoutManager        recyclerView.adapter = ListViewAdpter(items, this)    }    override fun onItemClick(view: View, index: Int) {        Log.i("view----:$view", "position----:$index")        when (index) {            0 -> {                //跳转到flutter  默认路由//                startActivity(FlutterActivity.createDefaultIntent(this))                //跳转到flutter 自定路由                startActivity(                    FlutterActivity.withNewEngine().initialRoute("/root").build(this)                )            }            1 -> {                val intent = Intent()                intent.setClass(this, WeatherActivity().javaClass)                startActivity(intent)            }            2 -> {                val intent = Intent()                intent.setClass(this, DataBindingActivity().javaClass)                startActivity(intent)            }            3 -> {                val intent = Intent()                intent.setClass(this, TabActivity().javaClass)                startActivity(intent)            }            4 -> {                val intent = Intent()                intent.setClass(this, BottomNavActivity().javaClass)                startActivity(intent)            }            5-> {                val intent = Intent()                intent.setClass(this, ThreadActivity().javaClass)                startActivity(intent)            }            6-> {                val intent = Intent()                intent.setClass(this, LoginActivity().javaClass)                startActivity(intent)            }           7-> {                val intent = Intent()                intent.setClass(this, LooperActivity().javaClass)                startActivity(intent)            }            8-> {                val intent = Intent()                intent.setClass(this, QrScanActivity().javaClass)                startActivity(intent)            }        }    }}