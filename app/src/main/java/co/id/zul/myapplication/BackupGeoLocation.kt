//package co.id.zul.myapplication
//
//import android.Manifest
//import android.app.AlertDialog
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.location.Address
//import android.location.Geocoder
//import android.location.Location
//import android.location.LocationManager
//import android.net.ConnectivityManager
//import android.net.Network
//import android.os.Build
//import android.os.Bundle
//import android.provider.Settings
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import kotlinx.android.synthetic.main.activity_main.*
//import java.util.*
//
//class MainActivity : AppCompatActivity() {
//
//    private var latitude: Double = 0.0
//    private var longitude: Double = 0.0
//    private val locationPermissionCode = 100
//    private var myProvince = ""
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        button_getLocation.setOnClickListener {
//            val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//                buildAlertMessageNoGps()
//            } else {
//                if (checkAndRequestPermissions()) {
//                    trackLocation()
//                }
//            }
//        }
//    }
//
////    override fun onRequestPermissionsResult(
////        requestCode: Int,
////        permissions: Array<out String>,
////        grantResults: IntArray
////    ) {
////        when (requestCode) {
////            locationPermissionCode -> {
////                if (grantResults.isNotEmpty() && grantResults[0] ==
////                    PackageManager.PERMISSION_GRANTED
////                ) {
////                    trackLocation()
////                } else {
////                    Toast.makeText(
////                        this,
////                        "Need to enable GPS for getting your location",
////                        Toast.LENGTH_LONG
////                    ).show()
////                }
////            }
////        }
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
////    }
////
////    private fun buildAlertMessageNoGps() {
////        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
////        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
////            .setCancelable(false)
////            .setPositiveButton(
////                "Yes"
////            ) { dialog, id ->
////                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
////            }
////            .setNegativeButton(
////                "No"
////            ) { dialog, id ->
////                dialog.cancel()
////            }
////        val alert: AlertDialog = builder.create()
////        alert.show()
////    }
////
////    private fun checkAndRequestPermissions(): Boolean {
////        val permissionsAccessFineLocation = ContextCompat.checkSelfPermission(
////            this,
////            Manifest.permission.ACCESS_FINE_LOCATION
////        )
////        val listPermissionsNeeded: MutableList<String> = ArrayList()
////        if (permissionsAccessFineLocation != PackageManager.PERMISSION_GRANTED) {
////            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
////        }
////        if (listPermissionsNeeded.isNotEmpty()) {
////            ActivityCompat.requestPermissions(
////                this,
////                listPermissionsNeeded.toTypedArray(),
////                locationPermissionCode
////            )
////            return false
////        }
////        return true
////    }
////
////    private fun trackLocation() {
////        if (ActivityCompat.checkSelfPermission(
////                this,
////                Manifest.permission.ACCESS_FINE_LOCATION
////            )
////            != PackageManager.PERMISSION_GRANTED
////        ) {
////            Toast.makeText(
////                this,
////                "You don't have permission to do this action",
////                Toast.LENGTH_LONG
////            ).show()
////        } else {
////            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
////            val providers: List<String> = lm.getProviders(true)
////            var location: Location? = null
////            for (provider in providers) {
////                val l: Location = lm.getLastKnownLocation(provider) ?: continue
////                if (location == null || l.accuracy < location.accuracy) {
////                    location = l
////                }
////            }
////            if (location != null) {
////                latitude = location.latitude
////                longitude = location.longitude
////                getLocation(latitude, longitude)
////            } else {
////                text_view_your_province_location.text = getString(R.string.province_not_found)
////                text_view_province_location.text = ""
////                Toast.makeText(
////                    this,
////                    "Sometimes it caused because you have slow internet connection",
////                    Toast.LENGTH_LONG
////                ).show()
////            }
////        }
////    }
////
////    private fun getLocation(currentLatitude: Double, currentLongitude: Double) {
////        val addresses: List<Address>
////        val geoCoder = Geocoder(this, Locale.getDefault())
////
////        addresses = geoCoder.getFromLocation(
////            currentLatitude,
////            currentLongitude,
////            1
////        )
////
////        val address: String = addresses[0].getAddressLine(0)
////        val city: String = addresses[0].locality
////        val state: String = addresses[0].adminArea
////        val country: String = addresses[0].countryName
////        val postalCode: String = addresses[0].postalCode
////        val knownName: String = addresses[0].featureName
////
////        if (state == myProvince) {
////            Toast.makeText(
////                this, "Your province still $myProvince",
////                Toast.LENGTH_LONG
////            ).show()
////        } else {
////            myProvince = state
////            text_view_your_province_location.text = getString(R.string.current_province)
////            text_view_province_location.text = myProvince
////        }
////    }
//
//}
