package moyashi.kuroppe.p_01jhardwarekeyplugin

import android.util.Log
import android.view.KeyEvent
import com.unity3d.player.UnityPlayer.UnitySendMessage
import com.unity3d.player.UnityPlayerActivity

class PlayerActivity : UnityPlayerActivity() {

    override fun dispatchKeyEvent(key: KeyEvent?): Boolean {
        UnitySendMessage("PlayerController", "pushed", key?.keyCode?.toKeyName())
        return super.dispatchKeyEvent(key)
    }
}


