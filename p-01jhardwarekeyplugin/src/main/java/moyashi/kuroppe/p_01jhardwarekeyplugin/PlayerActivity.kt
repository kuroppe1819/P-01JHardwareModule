package moyashi.kuroppe.p_01jhardwarekeyplugin

import android.view.KeyEvent
import com.unity3d.player.UnityPlayer.UnitySendMessage
import com.unity3d.player.UnityPlayerActivity

class PlayerActivity : UnityPlayerActivity() {

     private val pushedKey = fun(): () -> Boolean {
        var pushed = false

        return {
            pushed = !pushed
            pushed
        }
    }()

    override fun dispatchKeyEvent(key: KeyEvent?): Boolean {
        if (!pushedKey()) return false
        UnitySendMessage("PlayerController", "pushed", key?.keyCode?.toKeyName())
        return super.dispatchKeyEvent(key)
    }
}


