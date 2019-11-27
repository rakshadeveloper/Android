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
    var lastLat: Double = 0.0
    var lastLong: Double = 0.0
    var currentLat: Double = 0.0
    var currentLng: Double = 0.0
    var dist: Float = 0.0f
    var speed: Float = 0.0F

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
//        disableView()
        getLocation()
        dist()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissions)) {
                Handler().post({
                    getLocation()

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
//        btn_get_location.setOnClickListener {
//        }
        btn_get_location.setOnClickListener {
            hasGps = false
            hasNetwork = false
            getLocation()
        }

        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if ((hasGps || hasNetwork) && checkPermission(permissions)) {

            if (hasGps) {
                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0F, object : LocationListener {
//                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationGps = location
                            speed = locationGps!!.speed
                            tv_result.append("\nGPS ")
                            tv_result.append("\nLatitude : " + locationGps!!.latitude)
                            tv_result.append("\nLongitude : " + locationGps!!.longitude)
                            Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
                            Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)

                            Log.e("startTime", "${getTime()}")
                            Log.e("speed", "${tvspeed}")
                            startTime.text = "Time : ${getTime()}"
//                            tvspeed.text = "Speed : ${getSpeed()} km/h"
                            tvspeed.text = "Speed : $speed m/s"

                            tvLatLong.text = "$lastLat + $lastLong"
                            currentLat = locationGps!!.latitude
                            currentLng = locationGps!!.longitude
//                            tvDistnace.append( dist().toString())
                            dist()
                            Log.e("distance", "${dist()}")
                            tvDistnace.text = "Distnace : ${dist()} Km"
//                            tvDistnace.append("\nDist : " + dist())
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
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0F, object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationNetwork = location
                            speed = locationNetwork!!.speed
                            tv_result.append("\nNetwork ")
                            tv_result.append("\nLatitude : " + locationNetwork!!.latitude)
                            tv_result.append("\nLongitude : " + locationNetwork!!.longitude)
                            Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
                            Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)

                            Log.e("startTime", "${getTime()}")
                            Log.e("speed", "${tvspeed}")
                            startTime.text = "Time : ${getTime()}"
//                            tvspeed.text = "Speed : ${getSpeed()} km/h"

                            tvLatLong.text = "$lastLat + $lastLong"
                            currentLat = locationNetwork!!.latitude
                            currentLng = locationNetwork!!.longitude
//                            tvDistnace.append( dist().toString())
//                            dist()
                            Log.e("distance", "${dist()}")
                            tvDistnace.text = "Distnace : ${dist()} Km"
//                            tvDistnace.append("\nDist : " + dist())
                            tvspeed.text = "Speed : $speed m/s"
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


        if (lastLat == 0.0 && lastLong == 0.0) {

            val lati1 = currentLat
            val longi1= currentLng

            val dLat = Math.toRadians(currentLat - lati1)
            val dLng = Math.toRadians(currentLng - longi1)
            val a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lati1)) * Math.cos(
                    Math.toRadians(currentLat)
                ) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2)
            val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
            dist = (earthRadius * c).toFloat()
//            dist /= 1000
            dist += dist
            lastLat = currentLat
            lastLong = currentLng
            return dist
        }
        else {
            val dLat = Math.toRadians(currentLat - lastLat)
            val dLng = Math.toRadians(currentLng - lastLong)
            val a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lastLat)) * Math.cos(
                    Math.toRadians(currentLat)
                ) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2)
            val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
            dist = (earthRadius * c).toFloat()
//            dist /= 1000
            dist += dist
            lastLat = currentLat
            lastLong = currentLng
            return dist
        }

    }

    private fun getTime (): String {
        current = System.currentTimeMillis()
        // Creating date format
        // Creating date format
        val simple: DateFormat = SimpleDateFormat("HH:mm:ss")
        // Creating date from milliseconds
        // using Date() constructor

        val result = Date(current)
        return simple.format(result)

    }
//    fun getSpeed(): Float {
//        current /= 1000
//        current /= 60
//        var speed: Float = dist() / current
//        return speed
//    }

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
