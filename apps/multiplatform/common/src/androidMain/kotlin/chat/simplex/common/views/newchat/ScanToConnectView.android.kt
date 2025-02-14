package chat.simplex.common.views.newchat

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import chat.simplex.common.model.ChatModel
import chat.simplex.common.model.RemoteHostInfo
import com.google.accompanist.permissions.rememberPermissionState

@Composable
actual fun ScanToConnectView(chatModel: ChatModel, rh: RemoteHostInfo?, close: () -> Unit) {
  val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
  LaunchedEffect(Unit) {
    cameraPermissionState.launchPermissionRequest()
  }
  ConnectContactLayout(
    chatModel = chatModel,
    rh = rh,
    incognitoPref = chatModel.controller.appPrefs.incognito,
    close = close
  )
}
