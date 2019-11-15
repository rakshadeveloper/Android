import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import java.util.Locale
import androidx.appcompat.app.AppCompatActivity
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.location.LocationManager
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import com.example.speedtest.IBaseGpsListener
import com.example.speedtest.R

//import com.example.speedtest.gps
import java.util.*
import kotlin.system.exitProcess

@SuppressLint("Registered")
class MainActivity : AppCompatActivity(), IBaseGpsListener {
//    override fun onLocationChanged(location: Location) = Unit

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val locationManager = (Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0.1f,this)
        this.updateSpeed(null)

        val chkUseMetricUntis = (R.id.chkMetricUnits) as CheckBox
        chkUseMetricUntis.setOnCheckedChangeListener { buttonView, isChecked ->
            this@MainActivity.updateSpeed(null)
        }
    }

     override fun finish() {
        super.finish()
        exitProcess(0)
    }

    private fun updateSpeed(location: CLocation?) {
        var nCurrentSpeed = 0f

        if (location != null) {
            location.setUseMetricunits(this.useMetricUnits())
            nCurrentSpeed = location.speed
        }

        val fmt = Formatter(StringBuilder())
        fmt.format(Locale.US, "%5.1f", nCurrentSpeed)
        var strCurrentSpeed = fmt.toString()
        strCurrentSpeed = strCurrentSpeed.replace(' ', '0')

        var strUnits = "miles/hour"
        if (this.useMetricUnits()) {
            strUnits = "meters/second"
        }

        val txtCurrentSpeed = this.findViewById(R.id.txtCurrentSpeed) as TextView
        txtCurrentSpeed.text = "$strCurrentSpeed $strUnits"
    }

    private fun useMetricUnits(): Boolean {
        val chkUseMetricUnits = this.findViewById(R.id.chkMetricUnits) as CheckBox
        return chkUseMetricUnits.isChecked
    }

    override fun onLocationChanged(location: Location) {
        if (location != null)
        {
            val myLocation = CLocation(location, this.useMetricUnits())
            this.updateSpeed(myLocation)
        }
    }

    override fun onProviderDisabled(provider: String) {

    }

    override fun onProviderEnabled(provider: String) {

    }

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

    }

    override fun onGpsStatusChanged(event: Int) {

    }


}