package com.ray.beer.presentation.ui.common.view.button

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.setPadding
import com.ray.beer.presentation.R
import com.ray.beer.presentation.ui.common.UiCommonContract
import com.ray.beer.presentation.ui.common.util.delayOnLifecycle

/**
 * 사용법
 * style="Typography.ConfirmButton.Blue" 와 같이 스타일을 지정해 색을 설정한다.
 *
 * attribute
 * onIntervalClick : 딜레이를 넣어 다중 클릭을 방지한다.
 */
class ConfirmButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = R.attr.typographyButton
) : AppCompatButton(context, attributeSet, defStyle) {

    var onIntervalClick: OnClickListener? = null
        set(value) {
            field = value
            this.setOnClickListener {
                if (isClickable) {
                    isClickable = false
                    delayOnLifecycle(UiCommonContract.INTERVAL_CLICK_DURATION) {
                        isClickable = true
                    }
                    value?.onClick(it)
                }
            }
        }

    init {
        elevation = 0f
        gravity = Gravity.CENTER

        minWidth = 0
        minHeight = 0
        minimumWidth = 0
        minimumHeight = 0

        isClickable = true
        isEnabled = true
        isAllCaps = false
        stateListAnimator = null

        setPadding(resources.getDimension(R.dimen.spacing_s).toInt())
    }
}