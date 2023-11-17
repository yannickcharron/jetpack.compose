package ca.qc.cstj.navigationdemo.ui.screens.camera

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import ca.qc.cstj.navigationdemo.Screen
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode

@Composable
fun CameraScreen(navController: NavHostController) {
    val scanQrCodeLauncher = rememberLauncherForActivityResult(ScanQRCode()) { result ->
        when(result) {
            is QRResult.QRError -> TODO()
            QRResult.QRMissingPermission -> TODO()
            is QRResult.QRSuccess -> {
                Toast.makeText(navController.context, result.content.rawValue, Toast.LENGTH_LONG).show()
                navController.navigate(Screen.Analytics.route.replace("{href}", result.content.rawValue!!))
            }
            QRResult.QRUserCanceled -> TODO()
        }
    }
    LaunchedEffect("camera", block = {
        scanQrCodeLauncher.launch(null)
    })
}