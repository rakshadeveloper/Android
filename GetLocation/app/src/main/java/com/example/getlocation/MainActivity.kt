package com.example.getlocation

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


private const val PERMISSION_REQUEST = 10

class MainActivity : AppCompatActivity() {
    private var current: Long = 0
    var lati1: Double = 0.0
    var longi1: Double = 0.0
    var lati2: Double = 0.0
    var longi2: Double = 0.0

    lateinit var locationManager: LocationManager
    private var hasGps = false
    private var hasNetwork = false
    private var locationGps: Location? = null
    private var locationNetwork: Location? = null

    private var permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTranslationY = tvspeed.translationY

        disableView()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissions)) {
                Handler().post({
                    enableView()
                })
            } else {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        } else {
            Handler().post {
                enableView()
            }
        }
    }

    private fun disableView() {
        btn_get_location.isEnabled = false
        btn_get_location.alpha = 0.5F
    }

    private fun enableView() {
        btn_get_location.isEnabled = true
        btn_get_location.alpha = 1F
        btn_get_location.setOnClickListener { getLocation()
        getSpeed()
            tvspeed.text = getSpeed().toString()
        }
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (hasGps || hasNetwork) {

            if (hasGps) {
                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object : LocationListener {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationGps = location
                            tv_result.append("\nGPS ")
                            tv_result.append("\nLatitude : " + locationGps!!.latitude)
                            tv_result.append("\nLongitude : " + locationGps!!.longitude)
                            Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
                            Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
//                            val lati:String = tvLati.append(locationGps!!.latitude.toString()).toString()
//                            val longi:String = tvLongi.append(locationGps!!.longitude.toString()).toString()
//                            Log.d("Time", " Current in hh : " + getCurrentTime())
                            dist()
                            Log.e("startTime", "${startTime}")
                            startTime.text = "${getTime()}"
//                            tvspeed.text = "${getSpeed()}"
                            val lati1 = 26.8467
                            val longi1= 80.9462
                            tvLatLong.text = "$lati1 + $longi1"
                            lati2 = locationGps!!.latitude
                            longi2 = locationGps!!.longitude
//                            tvDistnace.append( dist().toString())
                            tvDistnace.text = "${dist()} Km"
                        }

                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                })

                val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (localGpsLocation != null)
                    locationGps = localGpsLocation
            }
            if (hasNetwork) {
                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0F, object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationNetwork = location
                            tv_result.append("\nNetwork ")
                            tv_result.append("\nLatitude : " + locationNetwork!!.latitude)
                            tv_result.append("\nLongitude : " + locationNetwork!!.longitude)
                            Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
                            Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                        }
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                })

                val localNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }

            if(locationGps!= null && locationNetwork!= null){
                if(locationGps!!.accuracy > locationNetwork!!.accuracy){
                    tv_result.append("\nNetwork ")
                    tv_result.append("\nLatitude : " + locationNetwork!!.latitude)
                    tv_result.append("\nLongitude : " + locationNetwork!!.longitude)
                    Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
                    Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                }else{
                    tv_result.append("\nGPS ")
                    tv_result.append("\nLatitude : " + locationGps!!.latitude)
                    tv_result.append("\nLongitude : " + locationGps!!.longitude)
                    Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
                    Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
                }
            }

        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
    }

    fun dist(): Float {
        val earthRadius = 6371000.0 //meters
        val dLat = Math.toRadians(lati2 - lati1)
        val dLng = Math.toRadians(longi2 - longi1)
        val a =
            Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lati1)) * Math.cos(
                Math.toRadians(lati2)
            ) *
                    Math.sin(dLng / 2) * Math.sin(dLng / 2)
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        var dist = (earthRadius * c).toFloat()
        dist /= 1000
        return dist
    }

    private fun getTime (): String {
        current = System.currentTimeMillis()
        // Creating date format
        // Creating date format
        val simple: DateFormat = SimpleDateFormat("HH:mm")

        // Creating date from milliseconds
        // using Date() constructor
        // Creating date from milliseconds
        // using Date() constructor
        val result = Date(current)

        // Formatting Date according to the
        // given format
        // Formatting Date according to the
        // given format
        // System.out.println(simple.format(result))
        return simple.format(result)

    }
    fun getSpeed(): Float {

        var speed: Float = dist() / current
        return speed
    }

    private fun checkPermission(permissionArray: Array<String>): Boolean {
        var allSuccess = true
        for (i in permissionArray.indices) {
            if (checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                allSuccess = false
        }
        return allSuccess
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            var allSuccess = true
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    allSuccess = false
                    val requestAgain = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if (requestAgain) {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Go to settings and enable the permission", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (allSuccess)
                enableView()
        }
    }
}
