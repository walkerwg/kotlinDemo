package com.example.myapplicationimport android.content.Intentimport android.os.Bundleimport android.util.Logimport android.widget.Buttonimport androidx.appcompat.app.AppCompatActivityimport io.flutter.embedding.android.FlutterActivity;class MainActivity : AppCompatActivity() {    var button: Button? = null    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        Log.d("ss", "ffffff")        setContentView(R.layout.activity_main)        button = findViewById(R.id.button)        button?.setOnClickListener {//            startActivity(FlutterActivity.createDefaultIntent(this))            startActivity(                FlutterActivity.withNewEngine().initialRoute("/root").build(this)            )        }    }}