import android.location.Location

class CLocation @JvmOverloads constructor(location: Location, bUseMetricUnits: Boolean = true) :
    Location(location) {


    var useMetricUnits = false
        private set

    init {
        this.useMetricUnits = bUseMetricUnits

        fun setUseMetricunits(bUseMetricUntis: Boolean) {
            this.useMetricUnits = bUseMetricUntis
        }

        fun distanceTo(dest: Location): Float {
            var nDistance = super.distanceTo(dest)
            if (!this.useMetricUnits) {
                //Convert meters to feet
                nDistance = nDistance * 3.28083989501312f
            }
            return nDistance
        }

        fun getAccuracy(): Float {
            var nAccuracy = super.getAccuracy()
            if (!this.useMetricUnits) {
                //Convert meters to feet
                nAccuracy = nAccuracy * 3.28083989501312f
            }
            return nAccuracy
        }

        fun getAltitude(): Double {
            var nAltitude = super.getAltitude()
            if (!this.useMetricUnits) {
                //Convert meters to feet
                nAltitude = nAltitude * 3.28083989501312
            }
            return nAltitude
        }

        fun getSpeed(): Float {
            var nSpeed = super.getSpeed() * 3.6f
            if (!this.useMetricUnits) {
                //Convert meters/second to miles/hour
                nSpeed = nSpeed * 2.2369362920544f / 3.6f
            }
            return nSpeed

        }

    }

}