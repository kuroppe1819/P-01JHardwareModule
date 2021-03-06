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

    private fun toKeyName(num: Int): String {
        for (key in HardwareKey.values()) {
            if (num == key.assignedNumber) return key.name
        }
        return ""
    }

    override fun dispatchKeyEvent(key: KeyEvent): Boolean {
        if (!pushedKey()) return false
        UnitySendMessage("Player", "pushed", toKeyName(key.keyCode))
        return super.dispatchKeyEvent(key)
    }
}


